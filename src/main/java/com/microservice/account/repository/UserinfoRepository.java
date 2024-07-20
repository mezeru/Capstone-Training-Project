package com.microservice.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Userinfo;

public interface UserinfoRepository extends JpaRepository<Userinfo, Integer> {
	
	

}
