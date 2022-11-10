package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentRest {

	private DepartmentService departmentService;
	
	public DepartmentRest(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping("/api/createDepartment")
	public long createDepartment(@RequestParam(name = "departnemtName") String departmentName) {
		return departmentService.createDepartment(departmentName);
	}
	
	@GetMapping("/api/department/{departmentId}")
	public Department findById(@PathVariable("departmentId") long departmentId) {
		return departmentService.findById(departmentId);
	}
	
	@GetMapping("/api/departments")
	public List<Department> findAll() {
		return departmentService.findAll();
	}
	
}
