package com.jpa.daoservice;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.jpa.Book;
import com.jpa.jpa.Department;
import com.jpa.jpa.Employee;
import com.jpa.jpa.Goals;
import com.jpa.jpa.Player;
import com.jpa.jpa.Publisher;
import com.jpa.jpa.Team;
import com.jpa.repository.BookRepository;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.GoalsRepository;
import com.jpa.repository.TeamRepository;

@Component
public class Operations {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private GoalsRepository goalsRepository;

	// @Autowired
	// private EmployeeDao employeeDao;
	Employee employee;
	Department department;
	// Goals goals;

	public void insert(String name) {
		//String name = "Disha";

		String address = "London";
		String depName = "Development";

		// String dep = "Multi Purpose";

		double sal = 10.0;
		employee = new Employee();
		employee.setName(name);
		employee.setAddress(address);
		// employee.setDepartment(dep);
		employee.setSalary(sal);
		employee.setGoal(1);

		// Seeting the department
		department = new Department();
		List <Department> d=departmentRepository.findAll();
		int i=0;
		if(d==null){
			i=0;
		}else{
			i=d.get(d.size()-1).getId();
		}
		
		department.setId(++i);
		department.setDepName(depName);

		// Setting the goals
//		Goals goal1 = new Goals();
//		//goal1.setGoalId(7);
//		goal1.setGoalName("Development");
//
//		Goals goal2 = new Goals();
//		//goal2.setId(4);
//		goal2.setGoalName("Test");
//		Set<Goals> goals=new HashSet<Goals>();
//		goals.add(goal1);
//		goals.add(goal2);
		//employee.getGoals().add(goal1);
		//employee.getGoals().add(goal2);

		//employee.setGoals(goals);
		employee.setDepartment1(department);
		employeeRepository.save(employee);
	}

	public void insertDep() {
		String depName = "Development";

		department = new Department();
		department.setId(2);
		department.setDepName(depName);
		departmentRepository.save(department);

	}

	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee find(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.get();
	}

	public void findByName(String name) {

		employee = employeeRepository.findByName(name);
		printEmployee(employee);
	}

	public void findByNamewithQuery(String name) {

		employee = employeeRepository.findEmployeeByName(name);
		printEmployee(employee);
	}

	public void findByNamewithQueryWithNative(String name) {

		employee = employeeRepository.findEmployeeBynamewithNative(name);
		printEmployee(employee);
	}
	
	public void findByNamewithNamedQuery() {

		List<Employee> employees = employeeRepository.findAllOrderedByNameDescending();
		if(employees.isEmpty()){
			System.out.println("No Data");
		}
		else{
			employees.forEach(emp -> {
				System.out.println("ID : " + emp.getId() + ", Name : " + emp.getName() + ", Department : " + ", Salary : "
						+ emp.getSalary());
			});
		}
	}
	
	public void printEmployee(Employee emp) {
		System.out.println("ID : " + emp.getId() + ", Name : " + emp.getName() + ", Department : "+emp.getDepartment1().getDepName());
		// System.out.println(emp);
	}

	public void randomQ() {

		TypedQuery<Employee> query = em.createQuery("select p from Employee p where p.name like '%j%'", Employee.class);

		List<Employee> employees = query.getResultList();
		if(employees.isEmpty()){
			System.out.println("No Data");
		}
		else{
			employees.forEach(emp -> {
				System.out.println("ID : " + emp.getId() + ", Name : " + emp.getName() + ", Department : " + ", Salary : "
						+ emp.getSalary());
			});
		}
	}

	public List<Employee> findAllEmp(){
		employeeRepository.findAll().forEach(emp -> {
			System.out.println("ID : " + emp.getId() + ", Name : " + emp.getName() + ", Department : " + ", Salary : "
					+ emp.getSalary());
		});
		
		return employeeRepository.findAll();
	}
	
	public void findAllEmpByDept(){
		departmentRepository.findAll().forEach(emp -> {
			System.out.println("ID : " + emp.getId() + ", Name : " + emp.getDepName() + ", Department : " + ", Employee Name : "
					+ emp.getEmployee().getName());
		});
	}
	
	@Autowired
	private TeamRepository teamRepository;
	
	public void insertTeams(){
		Team team = new Team("Barcelona");
        Set<Player> players = new HashSet<Player>();
         
        Player p1 = new Player("Messi");
        Player p2 = new Player("Xavi");
         
        p1.setTeam(team);
        p2.setTeam(team);
         
        players.add(p1);
        players.add(p2);
         
        team.setPlayers(players);
        teamRepository.save(team);
	}
	
	@Autowired
	private BookRepository bookRepository;
	public void insertBooks(){
		Book book = new Book();
		book.setName("Book 1");
		Publisher publisher1= new Publisher();
		publisher1.setName("Publisher A");
		Publisher publisher2= new Publisher();
		publisher2.setName("Publisher B");
		book.getPublisher().add(publisher1);
		book.getPublisher().add(publisher2);
		bookRepository.save(book);
	}
	
	public static void main(String[] args) {

	}

}
