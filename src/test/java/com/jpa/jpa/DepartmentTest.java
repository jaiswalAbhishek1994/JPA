package com.jpa.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpa.repository.DepartmentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan({ "com.jpa" })
@EntityScan("com.jpa.jpa")
@EnableJpaRepositories("com.jpa.repository")
// @ContextConfiguration(locations= "classpath:META-INF/test-context.xml")
public class DepartmentTest {

	@Autowired
	DepartmentRepository departmentReporitory;

	@Test
	public void test() {
		Department department = new Department();
		department.setId(3);
		department.setDepName("Development");

		departmentReporitory.save(department);
		Optional<Department> dbdep = departmentReporitory.findById(department.getId());

		assertNotNull(dbdep.get());
		assertEquals("Development", dbdep.get().getDepName());
	}
}
