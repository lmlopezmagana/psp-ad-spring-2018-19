package com.salesianostriana.rest.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Person {
	
	@Id @GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
	
	public Person( ) {}
	
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}
