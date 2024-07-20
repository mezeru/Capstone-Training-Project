package com.microservice.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
