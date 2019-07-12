package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpa.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
