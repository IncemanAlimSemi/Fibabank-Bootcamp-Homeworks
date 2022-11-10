package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	long createEmployee(String employeeName, double monthlySalary, long departmentId);
	Employee findById(long employeeId);
	
}
