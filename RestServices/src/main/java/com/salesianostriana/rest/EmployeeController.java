package com.salesianostriana.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("/employees")
	public List<Employee> all() {
		return repository.findAll();
	}

//	@PostMapping("/employees")
//	public Employee newEmployee(@RequestBody Employee newEmployee) {
//		return repository.save(newEmployee);
//	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {
		Employee e = repository.save(newEmployee);
		
//		return ResponseEntity
//				.status(HttpStatus.CREATED)
//				.body(e);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(e.getId()).toUri();
		
		return ResponseEntity
				.created(location)
				.body(e);
	}
	
	@GetMapping("/employees/{id}")
	public Employee one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));
	}

//	@PutMapping("/employees/{id}")
//	public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//		return repository.findById(id)
//			.map(employee -> {
//				employee.setName(newEmployee.getName());
//				employee.setRole(newEmployee.getRole());
//				return repository.save(employee);
//			})
//			.orElseGet(() -> {
//				newEmployee.setId(id);
//				return repository.save(newEmployee);
//			});
//	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		Employee updated = repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setRole(newEmployee.getRole());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(updated.getId()).toUri();
		
		return ResponseEntity
				.created(location)
				.body(updated);
		
	}

//	@DeleteMapping("/employees/{id}")
//	public void deleteEmployee(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	
	

}
