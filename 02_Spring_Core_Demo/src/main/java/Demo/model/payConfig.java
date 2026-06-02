package Demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class payConfig {
	@Bean
	public paymentMethod credit() {
		return new creditCard();
	}

}
