package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.HR;
import com.microservice.account.repository.HRRepository;

@Service
public class HRService {
	
	@Autowired
	public HRRepository hrRepository;

	public HR addHr(HR hr) {
		return hrRepository.save(hr);
		
	}

	public HR getHrByUserID(int userinfoId) {
		
		return hrRepository.getByUserinfoId(userinfoId);
		
	}
	
	
	

}
