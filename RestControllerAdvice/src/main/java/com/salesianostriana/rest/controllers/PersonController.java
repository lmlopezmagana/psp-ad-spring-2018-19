package com.salesianostriana.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.rest.data.Person;
import com.salesianostriana.rest.data.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	@GetMapping("/people")
	public List<Person> all() {
		return repository.findAll();
	}
	
	@GetMapping("/person/{id}")
	public Person one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	
	@PostMapping("/person")
	public Person newPerson(@RequestBody Person person) {
		if (person.getId() != null) {
			throw new NewPersonWithIdException();
		} 
		
		return repository.save(person);
	}
	
	

}
