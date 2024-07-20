package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.RoleType;
import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.model.HR;
import com.microservice.account.model.Manager;
import com.microservice.account.model.Userinfo;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.HRService;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.UserinfoService;

@RestController
public class HRController {
	
	@Autowired
	private HRService hrService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/api/HR/add")
	public ResponseEntity<?> addHr(@RequestBody HR hr) {
		
		Userinfo userinfo = hr.getUserinfo();
		
		String rawPass = userinfo.getPassword();
		String encryptedPass = passwordEncoder.encode(rawPass);
		userinfo.setPassword(encryptedPass);
		userinfo.setRole(RoleType.HR);
		
		userinfoService.addUserinfo(userinfo);
		hr.setUserinfo(userinfo);
		hr = hrService.addHr(hr);
		return ResponseEntity.ok().body(hr);
		
	}
	
	@PutMapping("/api/HR/updateManager/{employeeId}/{managerId}")
	public ResponseEntity<?> updateManager(@PathVariable("employeeId") int employeeId, @PathVariable("managerId") int managerId){
		
		
		
		try {
			Employee employee;
			Manager manager;
			employee = employeeService.findEmployeeById(employeeId);
			manager = managerService.getManagerById(managerId);
			
			employee.setManager(manager);
			
			employee = employeeService.addEmployee(employee);
			
			return ResponseEntity.ok().body(employee);
			
			
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
		
		
	}

}
