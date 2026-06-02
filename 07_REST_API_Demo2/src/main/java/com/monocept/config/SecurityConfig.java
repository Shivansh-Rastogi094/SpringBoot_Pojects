package com.monocept.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf-> csrf.disable()).authorizeHttpRequests
											(auth-> auth.requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("Admin","student")
													.requestMatchers(HttpMethod.PUT,"/api/students/**").hasAnyRole("Admin","student")
													.requestMatchers(HttpMethod.PATCH,"/api/students/**").hasAnyRole("Admin","student")
													.requestMatchers(HttpMethod.POST,"/api/students/**").hasRole("Admin")
													.requestMatchers(HttpMethod.DELETE,"/api/students/delete/**").hasRole("Admin")
													.anyRequest().authenticated()
													).httpBasic(Customizer.withDefaults()).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	@Bean
	UserDetailsService detailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails Admin =User.builder().username("Admin").password(passwordEncoder.encode("Admin@123")).roles("Admin").build();
		UserDetails student =User.builder().username("student").password(passwordEncoder.encode("student@123")).roles("student").build();
		
		return new InMemoryUserDetailsManager(Admin,student);
	}
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
