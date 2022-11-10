package com.example.demo.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping("/employee/get")
	@ResponseBody
	public String getEmployee() {
		long employeeId = 301;
		String url = "http://localhost:8080/api/employee/"+employeeId;
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(url, Employee.class);
		System.out.println("Ürün: " + employee.getEmployeeName());
		return "Edinme Basarılı " + employee.getEmployeeId() + " " + employee.getMonthlySalary();
	}
	
	@GetMapping("/employee/post")
	@ResponseBody
	public String postEmployee() {
		Employee employee = new Employee(0, "Mahmut", 1000);
		String url = "http://localhost:8080/api/employee";
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(url, employee, Employee.class);
		return "Yollama Basarili " + result.getEmployeeId();
	}
	
	@GetMapping("/employee/put")
	@ResponseBody
	public String putEmployee() {
		Employee employee = new Employee(0, "Ahmet", 1000);
		String url = "http://localhost:8080/api/employee";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
		return "Koyma Başarılı";
	}
	
	@GetMapping("/employee/delete")
	@ResponseBody
	public String deleteEmployee() {
		long employeeId = 303;
		String url = "http://localhost:8080/api/employee/"+employeeId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Başarılı";
	}
}
