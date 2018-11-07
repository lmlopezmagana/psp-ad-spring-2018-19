package com.salesianostriana.rest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.salesianostriana.rest.data.Person;
import com.salesianostriana.rest.data.PersonRepository;

@SpringBootApplication
public class RestControllerAdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestControllerAdviceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(PersonRepository repository) {
		return args -> {
			Arrays.asList(
					new Person("Luis Miguel", "López", "luismi.lopez@salesianos.edu"),
					new Person("Jesús", "Casanova", "jesus.casanova@salesianos.edu"),
					new Person("Miguel", "Campos", "miguel.campos@salesianos.edu"),
					new Person("Javier", "Bernal", "javier.bernal@salesianos.edu"),
					new Person("Diego", "Molina", "diego.molina@salesianos.edu")
			)
			.forEach(person -> repository.save(person));
		};
	}
}
