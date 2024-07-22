package com.microservice.account.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.model.Userinfo;
import com.microservice.account.service.UserinfoService;

@RestController
public class AuthController {
	
	@Autowired
	private UserinfoService userinfoService;

	@GetMapping("/api/login")
	public ResponseEntity<Userinfo> login(Principal principal) { // Dependency Injection
		
		
		Userinfo userinfo = (Userinfo) userinfoService.loadUserByUsername(principal.getName());
		
		return ResponseEntity.ok().body(userinfo);
		
	}
	
}
