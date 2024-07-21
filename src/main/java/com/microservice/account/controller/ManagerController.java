package com.microservice.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.RoleType;
import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Manager;
import com.microservice.account.model.PointsReward;
import com.microservice.account.model.Userinfo;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.PointsRewardService;
import com.microservice.account.service.UserinfoService;

@RestController
public class ManagerController {
	
	@Autowired
	private PointsRewardService pointsRewardService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/api/Manager/add")
	public ResponseEntity<?> addManager(@RequestBody Manager manager){
		
		Userinfo userinfo = manager.getUserinfo();
		
		String rawPass = userinfo.getPassword();
		String encryptedPass = passwordEncoder.encode(rawPass);
		userinfo.setPassword(encryptedPass);
		userinfo.setRole(RoleType.MANAGER);
		userinfoService.addUserinfo(userinfo);
		
		manager.setUserinfo(userinfo);
		manager = managerService.addManager(manager);
		
		return ResponseEntity.ok().body(manager);
	
	}
	
	@GetMapping("/api/Manager/empSuper/{managerId}")
	public ResponseEntity<?> getEmployeesSupervised(@PathVariable int managerId){
		
		List<Employee> list = employeeService.getEmployeesUnderManager(managerId);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping("/api/Manager/addPoints/{managerId}/{employeeId}")
	public ResponseEntity<?> addPoints(@PathVariable("managerId") int managerId, 
			@PathVariable("employeeId") int employeeId, 
			@RequestBody PointsReward pointsRewarded)
	{
		
		Employee employee = null;
		Manager manager = null;
		
			
			try {
				employee = employeeService.findEmployeeById(employeeId);
			} catch (ResourceNotFound e) {
				// TODO Auto-generated catch block
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			
			
			try {
				manager = managerService.getManagerById(managerId);
			} catch (ResourceNotFound e) {
				// TODO Auto-generated catch block
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			
			
			employee.setPoints(pointsRewarded.getPoints() + employee.getPoints());
			
			employeeService.addEmployee(employee);
			
			pointsRewarded.setEmployee(employee);
			pointsRewarded.setManager(manager);
			
			pointsRewarded = pointsRewardService.addPoints(pointsRewarded);
			
			return ResponseEntity.ok().body(pointsRewarded);	
			
		
	}
	
}
