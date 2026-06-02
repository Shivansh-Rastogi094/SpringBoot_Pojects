package com.monocept;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private final StudentRepository studentRepository;
	Application(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner cmdRunner(StudentRepository stdRepository) {
		return runer ->{
			Student std1= new Student(1,"Shivansh Rastogi",23);
			Student std2= new Student(2,"Rahul Tripathi",24);
			
			stdRepository.save(std1);
			stdRepository.save(std2);
			
			Optional<Student> foundedStd=studentRepository.findById(1);
			System.out.println("Student Found:" +foundedStd);
		};
	}

}
