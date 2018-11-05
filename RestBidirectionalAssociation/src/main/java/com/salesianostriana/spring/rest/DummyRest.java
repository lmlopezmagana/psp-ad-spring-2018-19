package com.salesianostriana.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyRest {
		
	@Autowired
	private DummyService service;
	
	@GetMapping({"/", "/users"})
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/items")
	public List<Item> getItems() {
		return service.getItems();
	}
	

}
