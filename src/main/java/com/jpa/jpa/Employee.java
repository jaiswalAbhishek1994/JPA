package com.jpa.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAllOrderedByNameDescending",
query = "SELECT e FROM Employee e ORDER BY e.name DESC")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "Name",nullable=false)
	private String name;

	@Column(name = "Address")
	private String address;

	// @Column (name="Department")
	// private int department;

	@Column(name="Goal")
	private int goal;
	
	@Column(name = "Salary")
	@NotNull
	private double salary;

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Department")
	private Department department1;

//	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL )
//	private Set<Goals> goals;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment1() {
		return department1;
	}

	public void setDepartment1(Department department1) {
		this.department1 = department1;
	}

//	public Set<Goals> getGoals() {
//		return goals;
//	}
//
//	public void setGoals(Set<Goals> goals) {
//		this.goals = goals;
//	}

	

}
