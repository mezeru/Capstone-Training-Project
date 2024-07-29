package com.microservice.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.dto.EmployeeManagerDto;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Manager;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.SearchService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class SearchController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/api/search/{searchName}")
	public ResponseEntity<?> searchEmployee(@PathVariable("searchName") String searchName) {
		
		List<Employee> empList = employeeService.getEmployeeByName(searchName);
		List<Manager> manList = managerService.getManagerByName(searchName);
		
		List<EmployeeManagerDto> results = searchService.convertToDto(empList, manList);
		
		
		return ResponseEntity.ok().body(results);
		
	}
	

}
