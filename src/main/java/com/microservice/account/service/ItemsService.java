package com.microservice.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.exceptions.ResourceNotFound;
import com.microservice.account.model.Items;
import com.microservice.account.repository.ItemsRepository;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsRepository itemsRepository;

	public Items addItem(Items item) {
		
		return itemsRepository.save(item);	
		
		
	}

	public List<Items> getAllItems() {
		
		return itemsRepository.findAll();		
		
	}
	
	public Items getItembyId(int id) throws ResourceNotFound {
		Optional<Items> optional = itemsRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new ResourceNotFound("Invalid Item ID");
		}
		
		return optional.get();

	}

}
