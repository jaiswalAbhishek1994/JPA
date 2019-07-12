package com.jpa.daoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.jpa.Department;
import com.jpa.repository.DepartmentRepository;

@Component
public class DepartmentOp {

	Department department;

	@Autowired
	private DepartmentRepository departmentRepository;

	public void insertDep() {
		String depName = "Development";

		department = new Department();
		// department.setId(1);
		department.setDepName(depName);
		departmentRepository.save(department);

	}

	// public static void main(String aa[]){
	// new DepartmentOp().insertDep();
	// }
}
