package com.microservice.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private double salary;
	
	@Column(nullable = false)
	private int points;
	
	@ManyToOne
	private Manager manager;

	
	@OneToOne
	private Userinfo userinfo;


	
	
	
}
