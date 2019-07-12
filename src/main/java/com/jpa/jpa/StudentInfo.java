package com.jpa.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "studentinfo")
public class StudentInfo {

	@Id
	@Column(name="Stud_Id")
	@NotNull
	private int studId;
	
	@Column(name="Name")
	@NotNull
	private String name;

	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="Stud_Id", insertable = false, updatable = false, nullable=false)
	private Student student;
	
	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
