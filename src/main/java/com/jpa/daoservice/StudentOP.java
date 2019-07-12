package com.jpa.daoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.jpa.Student;
import com.jpa.jpa.StudentInfo;
import com.jpa.repository.StudentRepository;

@Component
public class StudentOP {

	@Autowired
	private StudentRepository studentRepository;
	
	Student student;
	
	public void insertStudent(){
		student = new Student();
		
		StudentInfo s1=new StudentInfo();
		s1.setName("Abhishek");
		s1.setStudId(1);
		
		StudentInfo s2=new StudentInfo();
		s2.setName("Jadu");
		s2.setStudId(2);
		
		student.getStudentInfos().add(s1);
		student.getStudentInfos().add(s2);
		studentRepository.save(student);
	}
	
}
