package com.salesianostriana.rest.controllers;

public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(Long id) {
		super("Person not found - Id: " + id);
	}
	
}
