package com.salesianostriana.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name = "CUSTOMER_ORDER")
public class Order {

	private @Id @GeneratedValue Long id;
	
	private String description;
	private Status status;
		

	Order(String description, Status status) {

		this.description = description;
		this.status = status;
	}
}