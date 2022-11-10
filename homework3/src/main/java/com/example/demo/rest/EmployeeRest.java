package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

public class EmployeeRest {
	
	private EmployeeService employeeService;
	
	public EmployeeRest(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/api/createEmployee/{employeeName}/{monthlySalary}/{departmentId}")
	public long createDepartment(@PathVariable("employeeName") String employeeName, 
			@PathVariable("monthlySalary") double monthlySalary, 
			@PathVariable("departmentId") long departmentId) {
		return employeeService.createEmployee(employeeName, monthlySalary, departmentId);
	}
	
	@GetMapping("/api/employee/{employeeId}")
	public Employee findById(@PathVariable("employeeId") long employeeId) {
		return employeeService.findById(employeeId);
	}
}
