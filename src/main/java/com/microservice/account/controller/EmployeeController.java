package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.RoleType;
import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Manager;
import com.microservice.account.model.Userinfo;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.UserinfoService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/api/Employee/add/{managerId}")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee, @PathVariable("managerId") int managerId) {
		
		// Check in Manager Exists
		
		Manager managerObj = null;
		
		
		try {
			managerObj = managerService.getManagerById(managerId);
			
			
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		employee.setManager(managerObj);
		employee.setPoints(0);
		
		Userinfo userinfo = employee.getUserinfo();
		String rawPass = userinfo.getPassword();
		String encryptedPass = passwordEncoder.encode(rawPass);
		userinfo.setPassword(encryptedPass);
		userinfo.setRole(RoleType.EMPLOYEE);
		userinfoService.addUserinfo(userinfo);
		
		employee.setUserinfo(userinfo);
		employee = employeeService.addEmployee(employee);
		
		return ResponseEntity.ok().body(employee);
		
		
	}

}
