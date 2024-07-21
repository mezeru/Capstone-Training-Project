package com.microservice.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.model.Items;
import com.microservice.account.service.ItemsService;

@RestController
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@PostMapping("/api/Items/add")
	public ResponseEntity<?> addItem(@RequestBody Items item) {
		
		item = itemsService.addItem(item);
		
		return ResponseEntity.ok().body(item);
		
	}
	
	@GetMapping("/api/Items/getAll")
	public ResponseEntity<?> getAllItems(){
		
		List<Items> list = itemsService.getAllItems();
		
		return ResponseEntity.ok().body(list);
		
	}
	
}
