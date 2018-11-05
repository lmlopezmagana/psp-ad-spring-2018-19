package com.salesianostriana.spring.rest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
@Data @NoArgsConstructor @AllArgsConstructor
public class Item {
	
	private int id;
	private String itemName;
	
	//@JsonManagedReference
	private User owner;
	
	public Item(int id, String itemName) {
		this.id = id;
		this.itemName = itemName;
	}

}
