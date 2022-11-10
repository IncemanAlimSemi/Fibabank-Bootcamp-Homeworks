package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {

	Customer find(long customerId);
	List<Customer> findAll();
	void createCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(long customerId);
	
}