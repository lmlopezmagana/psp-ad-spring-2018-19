package com.salesianostriana.rest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salesianostriana.rest.data.ApiError;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<?> personNotFoundHandler(PersonNotFoundException ex) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), "Error");
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatus());
	}
	
	@ExceptionHandler(NewPersonWithIdException.class)
	public ResponseEntity<?> newPersonWithIdHandler(NewPersonWithIdException ex) {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), "Error");
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatus());
	}

}
