package com.microservice.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.RoleType;
import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Items;
import com.microservice.account.model.Manager;
import com.microservice.account.model.PointsReward;
import com.microservice.account.model.Userinfo;
import com.microservice.account.service.EmployeeItemsService;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.ItemsService;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.PointsHistoryService;
import com.microservice.account.service.PointsRewardEService;
import com.microservice.account.service.UserinfoService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class EmployeeController {
	
	@Autowired
	private PointsRewardEService pointsRewardService;
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeItemsService employeeItemsService;
	
	@Autowired
	private PointsHistoryService pointsHistoryService;
	
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
	
	@PostMapping("/api/Employee/redeemItem/{employeeId}/{itemId}")
	public ResponseEntity<?> redeemItem(@PathVariable("itemId") int itemId, @PathVariable("employeeId") int employeeId) {
		
		Employee employee = null;
		Items item = null;
		
		try {
			employee = employeeService.findEmployeeById(employeeId);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			return ResponseEntity.ok().body(e.getMessage());
		}
		
		try {
			item = itemsService.getItembyId(itemId);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			return ResponseEntity.ok().body(e.getMessage());
		}
		
		return employeeService.redeemItem(employee,item);
		
		
	}
	
	
	@GetMapping("/api/Employee/getItems/{employeeId}")
	public ResponseEntity<?> getItemsbyEmployee(@PathVariable("employeeId") int employeeId) {
		
		List<?> items = employeeItemsService.getItemsbyEmployee(employeeId);
		
		return ResponseEntity.ok().body(items);
		
	}
	
	
	
	@GetMapping("/api/Employee/getAll")
	public ResponseEntity<?> getAllEmployee(){
		
		List<Employee> employees = employeeService.getAllEmployee();
		
		return ResponseEntity.ok().body(employees);
		
		
	}
	
	// Get Employee by userinfo
	
	@GetMapping("/api/Employee/getEmployeeUserID/{userinfoId}")
	public ResponseEntity<?> getEmployeeByuserID(@PathVariable ("userinfoId") int userinfoId){
		
		Employee employee = employeeService.getEmployeeByUserID(userinfoId);
		
		return ResponseEntity.ok().body(employee);
		
	}
	
	@PutMapping("/api/Employee/update/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id){
		
		employee = employeeService.updateEmployee(employee,id);
		
		return ResponseEntity.ok(employee);
		
	}
	
	@DeleteMapping("/api/Employee/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
		
		employeeService.deleteEmployee(id);
		
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping("/api/Employee/getEmployee/{id}")
	public ResponseEntity<?> getEmployeebyId(@PathVariable("id") int id){
		
		Employee employee = null;
		
		try {
			employee = employeeService.findEmployeeById(id);
		} catch (ResourceNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body(employee);
		
	}
	
	@GetMapping("/api/Employee/getPointsHistory/{employeeId}")
	public ResponseEntity<?> getPointsHistory(@PathVariable("employeeId") int employeeId){
		
	
		
		List<?> list = pointsHistoryService.getPointsHistory(employeeId);
		
		
	    return ResponseEntity.ok().body(list);
		
		
	}

	

}
