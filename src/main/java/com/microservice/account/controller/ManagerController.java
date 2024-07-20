package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.RoleType;
import com.microservice.account.model.Manager;
import com.microservice.account.model.Userinfo;
import com.microservice.account.service.ManagerService;
import com.microservice.account.service.UserinfoService;

@RestController
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
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
	
}