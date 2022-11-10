package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private DepartmentRepository departmentRepository;
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public long createEmployee(String employeeName, double monthlySalary, long departmentId) {
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setMonthlySalary(monthlySalary);
		Optional<Department> optional = departmentRepository.findById(departmentId);
		if (optional.isPresent()) {
			Department department = optional.get();
			employee.setDepartment(department);
		}
		employeeRepository.save(employee);
		return employee.getEmployeeId();
	}

	@Override
	public Employee findById(long employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			return employee;
		}
		return null;
	}
	
}
