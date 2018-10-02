package com.salesianostriana.bcrypt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BCryptGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BCryptGeneratorApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner generate() {
		return args -> {
			BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
			
			String password = "admin";
			System.out.println(password + " -> " + bcryptPasswordEncoder.encode(password));

					
				
			
		};
	}
	
}
