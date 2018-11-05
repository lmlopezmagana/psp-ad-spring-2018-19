package com.salesianostriana.spring.rest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
	
	private int id;
	private String name;
	
	//@JsonBackReference
	public List<Item> userItems;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
		userItems = new ArrayList<Item>();
	}
	
	//Método helper
	public void addItem(Item i) {
		i.setOwner(this);
		this.userItems.add(i);
	}

}
