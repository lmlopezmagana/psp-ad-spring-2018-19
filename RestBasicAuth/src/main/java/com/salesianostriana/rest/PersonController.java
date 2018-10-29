package com.salesianostriana.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	@GetMapping("/people")
	public List<Person> all() {
		return repository.findAll();
	}

}
