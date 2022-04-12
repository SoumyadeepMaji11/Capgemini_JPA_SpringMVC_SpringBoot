package com.training.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Query("select e FROM Employee e WHERE e.emp_sal>50000")
	List<Employee>findbySalary50k();
	
	@Query("select e from Employee e where e.emp_sal<50000")
	List<Employee> findbySalaryLessThan50k();
}
