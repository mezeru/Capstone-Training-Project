package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Items;
import com.microservice.account.repository.ItemsRepository;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsRepository itemsRepository;

	public Items addItem(Items item) {
		
		return itemsRepository.save(item);	
		
		
	}

}
