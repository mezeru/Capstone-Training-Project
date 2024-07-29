package com.microservice.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.model.EmployeeItems;
import com.microservice.account.model.Items;
import com.microservice.account.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeItemsService employeeItemsService;

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
	

	public List<Employee> getEmployeesUnderManager(int managerId) {
		
		List<Employee> employees = employeeRepository.findByManagerId(managerId);
		
		return employees;
		
	}

	public ResponseEntity<?> redeemItem(Employee employee, Items item) {
		
		if(employee.getPoints() < item.getPoints()) {
			return ResponseEntity.badRequest().body("Insufficient Points");
		}
		
		EmployeeItems empItem = new EmployeeItems();
		empItem.setEmployee(employee);
		empItem.setItem(item);
		
		employee.setPoints(employee.getPoints() - item.getPoints());
		
		employeeRepository.save(employee);
		
		empItem = employeeItemsService.addRedemption(empItem);
		
		return ResponseEntity.ok(empItem);
			
		
	}

	public List<Employee> getAllEmployee() {
		
		List<Employee> list = employeeRepository.findAll();
		
		return list;
		
	}

	public Employee getEmployeeByUserID(int userinfoId) {
		
		return employeeRepository.getByUserinfoId(userinfoId);
		
	}

	public List<Employee> getEmployeeByName(String searchName) {
		
		return employeeRepository.getEmployeeByName(searchName);
		
	}

	public Employee updateEmployee(Employee employee, int id) {
		
		Employee emp = null;
		
		try {
			emp = findEmployeeById(id);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		emp.setJobtype(employee.getJobtype());
		emp.setName(employee.getName());
		emp.setPoints(employee.getPoints());
		
		return employeeRepository.save(emp);
		
	}
	
	

}
