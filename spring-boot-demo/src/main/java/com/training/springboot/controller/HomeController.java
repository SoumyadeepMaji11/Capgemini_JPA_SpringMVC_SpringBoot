package com.training.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springboot.model.Employee;
import com.training.springboot.model.Student;
import com.training.springboot.repository.EmployeeRepository;
import com.training.springboot.repository.StudentRepository;
import com.training.springboot.service.EmployeeService;

@RestController
public class HomeController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EmployeeRepository emprep;
	
	@Autowired
	EmployeeService es;
	
	@RequestMapping("/")
	public String getMsg()
	{
		return "Hello from spring boot";
	}
	
	@RequestMapping("/new")
	public void newStudent() {
	String query = "Insert into student values(221," +"'Demo user','Last')";
	int rows = jdbcTemplate.update(query);
	if(rows>0) {
		System.out.println("New row inserted successfully");
		}
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = repository.findAll();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/addemployee",method = RequestMethod.POST)
	public void newEmployee(@RequestBody Employee employees) {
		emprep.save(employees);
	}
	
	@RequestMapping(value= "/employee",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = emprep.findAll();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@RequestMapping(value="/employee50k",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployee50k(){
		List<Employee> employee = emprep.findbySalary50k();
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
	}
	
	@RequestMapping(value="/increaseSalary",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> increase() {
		List<Employee> employee = emprep.findbySalaryLessThan50k();
		List<Employee> emp = es.increment(employee);
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
}

