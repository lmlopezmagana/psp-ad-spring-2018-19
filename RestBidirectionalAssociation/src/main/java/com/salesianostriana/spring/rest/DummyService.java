package com.salesianostriana.spring.rest;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class DummyService {
	
	private List<User> listOfUsers;
	private List<Item> listOfItems;
	
	public List<User> getUsers() {
		return listOfUsers;
	}
	
	public List<Item> getItems() {
		return listOfItems;
	}
	
	@PostConstruct
	public void initData() {
		
		User user = new User(1, "John");
		Item item = new Item(1, "book");
		user.addItem(item);
		
		listOfUsers =  Arrays.asList(user);
		listOfItems = Arrays.asList(item);
		
	}

}
