package com.jpa.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpa.daoservice.Operations;

@SpringBootApplication
@ComponentScan({ "com" })
@EntityScan("com.jpa.jpa")
@EnableJpaRepositories("com.jpa.repository")
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(JpaApplication.class, args);
		Operations op = ac.getBean(Operations.class);
		// DepartmentOp depOp=ac.getBean(DepartmentOp.class);
		// for(int i=0;i<3;i++){
		 //op.insert("Sampath");
		 //op.findByNamewithNamedQuery();
		 op.findByNamewithQuery("Disha");
		 //op.findAllEmpByDept();
		// op.findByNamewithQueryWithNative("Disha");
		// op.delete(54);
		// Employee emp = op.find(4);
		// op.printEmployee(emp);
		// }
		// op.insert();
		 //op.findByName("Disha");
		 //op.randomQ();
		// depOp.insertDep();
		//op.findAllEmp();
		//op.insertTeams();
		//op.insertBooks();
		//StudentOP sop=ac.getBean(StudentOP.class);
		//sop.insertStudent();

	}

}
