package com.microservice.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}

	public Employee findEmployeeById(int employeeId) throws ResourceNotFound {
		
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		
		if(optional.isEmpty()) {
			throw new ResourceNotFound("Invalid Employee ID");
		}
		
		return optional.get();
	}
	
	

}
