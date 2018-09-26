package com.salesianostriana.bd.securitysample;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecuritySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritySampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(ApplicationContext appContext) {
		return args -> {
			Arrays.stream(appContext.getBeanDefinitionNames()).filter(s -> s.contains("Security")).forEach(System.out::println);
		};
	}
}
