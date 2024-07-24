package com.microservice.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Manager;
import com.microservice.account.model.PointsReward;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.PointsRewardEService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class PointsRewardController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private PointsRewardEService pointsRewardService;
	
	
	@PostMapping("/api/addPoints/{managerId}/{employeeId}")
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
	
	@GetMapping("api/getHistory/Manager/{managerId}")
	public ResponseEntity<?> getHistoryByManager(@PathVariable("managerId") int managerId){
		
		List<PointsReward> list = pointsRewardService.getHistoryByManager(managerId);
		
		
		return ResponseEntity.ok().body(list);
		
	}

}
