
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId, "Ahmet", 1000);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(301, "Ahmet", 1000));
		customerList.add(new Customer(302, "Mehmet", 2000));
		customerList.add(new Customer(303, "Mustafa", 3000));
		return customerList;
	}

	@Override
	public void createCustomer(Customer customer) {
		customer.setCustomerId(301);
		System.out.println("Ürün eklendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
	} 

	@Override
	public void updateCustomer(Customer customer) {
		customer.setCustomerId(301);
		System.out.println("Ürün güncellendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Ürün silindi " + customerId);
	} 

}
