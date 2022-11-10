package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public long createDepartment(String departmentName) {
		Department department = new Department();
		department.setDepartmentName(departmentName);
		departmentRepository.save(department);
		return  department.getDepartmentId();
	}

	@Override
	public Department findById(long departmentId) {
		Department department = new Department();
		Optional<Department> optional = departmentRepository.findById(departmentId);
		if (optional.isPresent()) {
			department = optional.get();
			return department;
		}
		
		return null;
	}

	@Override
	public List<Department> findAll() {
		List<Department> departments = new ArrayList<>();
		Iterable<Department> iterable = departmentRepository.findAll(); 
		
		for (Department department : iterable) {
			departments.add(department);
		}
		
		return departments;
	}

}
