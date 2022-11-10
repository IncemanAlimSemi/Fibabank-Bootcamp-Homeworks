package com.example.demo.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Customer;


@Controller
public class CustomerController {
	
	@GetMapping("/customer/get")
	@ResponseBody
	public String getCustomer() {
		long customerId = 301;
		String url = "http://localhost:8080/api/customer/"+customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		System.out.println("Ürün: " + customer.getCustomerName());
		return "Edinme Basarılı " + customer.getCustomerId() + " " + customer.getTotalDebit();
	}
	
	@GetMapping("/customer/post")
	@ResponseBody
	public String postCustomer() {
		Customer customer = new Customer(0, "Semi", 5400);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		Customer result = restTemplate.postForObject(url, customer, Customer.class);
		return "Yollama Basarili " + result.getCustomerId();
	}
	
	@GetMapping("/customer/put")
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(302, "Alim", 8000);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer), Void.class);
		return "Koyma Başarılı";
	}
	
	@GetMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer() {
		long customerId = 303;
		String url = "http://localhost:8080/api/customer/"+customerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Başarılı";
	}
}
