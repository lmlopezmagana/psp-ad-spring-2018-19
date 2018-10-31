package com.salesianostriana.rest;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.salesianostriana.rest.data.Person;
import com.salesianostriana.rest.data.PersonRepository;
import com.salesianostriana.rest.security.data.Authorities;
import com.salesianostriana.rest.security.data.User;
import com.salesianostriana.rest.security.data.UserRepository;

@SpringBootApplication
public class RestBasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestBasicAuthApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(PersonRepository repository, UserRepository userRepository) {
		return args -> {
			Arrays.asList(
					new Person("Luis Miguel", "López", "luismi.lopez@salesianos.edu"),
					new Person("Jesús", "Casanova", "jesus.casanova@salesianos.edu"),
					new Person("Miguel", "Campos", "miguel.campos@salesianos.edu"),
					new Person("Javier", "Bernal", "javier.bernal@salesianos.edu"),
					new Person("Diego", "Molina", "diego.molina@salesianos.edu")
			)
			.forEach(person -> repository.save(person));
			
			User u = new User();
			u.setUsername("admin");
			u.setPassword("admin");
			u.setEnabled(true);
		
			Authorities auth = new Authorities("ROLE_ADMIN", u);
			
			u.setAuthorities(Stream.of(auth).collect(Collectors.toSet()));
			
			userRepository.save(u);
			
			
			
		};
	}
}
