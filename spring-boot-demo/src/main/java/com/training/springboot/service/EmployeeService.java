package com.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springboot.model.Employee;
import com.training.springboot.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository emprep;

	public List<Employee> increment(List<Employee> employee)
	{
		for(int i=0 ; i<employee.size(); i++) {
			double salary = employee.get(i).getEmp_sal();
			double increase = (double)((salary*110)/100);
			employee.get(i).setEmp_sal(increase);
			emprep.save(employee.get(i));
		}
		
		return employee;
	}
}
