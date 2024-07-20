package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.microservice.account.service.ManagerService;
import com.microservice.account.service.UserinfoService;

public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

}
