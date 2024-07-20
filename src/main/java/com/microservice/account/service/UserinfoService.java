package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Userinfo;
import com.microservice.account.repository.UserinfoRepository;

@Service
public class UserinfoService {
	
	@Autowired
	private UserinfoRepository userinfoRepository;
	
	public Userinfo addUserinfo(Userinfo userinfo) {
		
		return userinfoRepository.save(userinfo);
		
	}

}
