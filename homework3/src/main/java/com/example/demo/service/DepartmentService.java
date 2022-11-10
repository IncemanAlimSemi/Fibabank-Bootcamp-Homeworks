package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {
	
	long createDepartment(String departmentName); 
	
	Department findById(long departmentId);
	
	List<Department> findAll();
	
	
}
