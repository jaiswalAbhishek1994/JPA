package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Custom Queries
	@Query("SELECT u FROM Employee u WHERE u.name = ?1")
	Employee findEmployeeByName(String name);

	@Query(value = "SELECT * FROM Employee u WHERE u.name = ?1", nativeQuery = true)
	Employee findEmployeeBynamewithNative(String name);

	//Named Queries
	List<Employee> findAllOrderedByNameDescending();
	
	public Employee findByName(String name);
}
