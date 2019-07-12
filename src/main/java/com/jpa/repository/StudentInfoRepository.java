package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpa.StudentInfo;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer> {

}
