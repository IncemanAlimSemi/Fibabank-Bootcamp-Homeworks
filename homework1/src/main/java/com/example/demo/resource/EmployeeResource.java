package com.example.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;

@RestController
public class EmployeeResource {
	
	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable("id")long employeeId) {
		Employee employee = new Employee(employeeId, "Ahmet", 1000);
		return employee;
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(301, "Ahmet", 1000));
		employeeList.add(new Employee(302, "Mehmet", 2000));
		employeeList.add(new Employee(303, "Mustafa", 3000));
		return employeeList;
	}
	
	@PostMapping("/api/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(301);
		System.out.println("Employee eklendi.");
		return employee;
	}
	
	@PutMapping("/api/employee")
	public void putEmployee(@RequestBody Employee employee) {
		System.out.println("Employee güncellendi.");
	}
	
	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployee(@PathVariable("id")long employeeId) {
		System.out.println("Employee silindi." + employeeId);
	}
}
