package com.microservice.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.microservice.account.model.EmployeeItems;

import com.microservice.account.repository.EmployeeItemsRepository;

@Service
public class EmployeeItemsService {

	@Autowired
	private EmployeeItemsRepository employeeItemsRepository;
	
	public EmployeeItems addRedemption(EmployeeItems empItem) {
		
		return employeeItemsRepository.save(empItem);
		
	}

	public List<EmployeeItems> getItemsbyEmployee(int employeeId) {
		
		
		
		return employeeItemsRepository.findItemsByEmployeeId(employeeId);
	}


}
