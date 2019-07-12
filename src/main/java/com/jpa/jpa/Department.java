package com.jpa.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "department")
// @Transactional
public class Department {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "id")
	private int id;

	@Column(name = "Dep_Name")
	private String depName;

	@OneToOne(mappedBy = "department1")
	private Employee employee;

	public int getId() {
		return id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

}
