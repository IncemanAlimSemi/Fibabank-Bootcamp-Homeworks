package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
