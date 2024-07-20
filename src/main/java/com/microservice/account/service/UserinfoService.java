package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Userinfo;
import com.microservice.account.repository.UserinfoRepository;

@Service
public class UserinfoService implements UserDetailsService{
	
	@Autowired
	private UserinfoRepository userinfoRepository;
	
	public Userinfo addUserinfo(Userinfo userinfo) {
		
		return userinfoRepository.save(userinfo);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Userinfo userinfo = userinfoRepository.findByUsername(username);
		
		return userinfo;
		
	}

}
