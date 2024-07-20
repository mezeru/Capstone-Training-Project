package com.microservice.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Manager;
import com.microservice.account.repository.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;

	public Manager addManager(Manager manager) {
		
		return managerRepository.save(manager);
		// TODO Auto-generated method stub
		
	}

	public Manager getManagerById(int managerId) throws ResourceNotFound {
		
		Optional<Manager> optional = managerRepository.findById(managerId);
		
		if(optional.isEmpty()) {
			throw new ResourceNotFound("Invalid Manager ID");
		}
		
		return optional.get();
		
		
	}

}
