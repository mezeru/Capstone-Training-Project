package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.RoleType;
import com.microservice.account.model.HR;
import com.microservice.account.model.Userinfo;
import com.microservice.account.service.HRService;
import com.microservice.account.service.UserinfoService;

@RestController
public class HRController {
	
	@Autowired
	private HRService hrService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/api/HR/add")
	public ResponseEntity<?> addHr(@RequestBody HR hr) {
		
		Userinfo userinfo = hr.getUserinfo();
		
		String rawPass = userinfo.getPassword();
		String encryptedPass = passwordEncoder.encode(rawPass);
		userinfo.setPassword(encryptedPass);
		userinfo.setRole(RoleType.HR);
		
		userinfoService.addUserinfo(userinfo);
		hr.setUserinfo(userinfo);
		HR savedHR = hrService.addHr(hr);
		return ResponseEntity.ok().body(savedHR);
		
	}

}
