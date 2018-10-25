package com.salesianostriana.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository repository;
	
	@GetMapping("/orders")
	public List<Order> all() {
		return repository.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Order one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
	}
	
	@PostMapping("/orders")
	public ResponseEntity<?> newOrder(@RequestBody Order order) {
		Order newOrder = repository.save(order);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(newOrder.getId()).toUri();
		
		return ResponseEntity
				.created(location)
				.body(newOrder);
	}
	
	@DeleteMapping("/orders/{id}/cancel")
	public ResponseEntity<?> cancel(@PathVariable Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
		
		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.CANCELLED);
			return ResponseEntity.ok(repository.save(order));
		}
		
		return ResponseEntity
				.status(HttpStatus.METHOD_NOT_ALLOWED)
				.body("You can't cancel an order that is in the " + order.getStatus() + " status");
	}

}
