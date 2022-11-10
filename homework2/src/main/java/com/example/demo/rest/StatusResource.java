package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;

@RestController
public class StatusResource {
	
	@GetMapping("/status/ok/{id}")
	public ResponseEntity<?> getOkay(@PathVariable("id")long customerId) {
		Customer customer = new  Customer(customerId, "Selim", 12345);
		return ResponseEntity.ok().body(customer);
	}
	
	@GetMapping("/status/notfound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable("id")long customerId) {
		if(customerId == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer bulunamadı");
		}
		Customer customer = new  Customer(customerId, "Selim", 12345);
		return ResponseEntity.ok().body(customer);
	}
}
