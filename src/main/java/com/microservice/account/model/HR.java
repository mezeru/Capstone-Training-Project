package com.microservice.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.microservice.account.enums.RoleType;

@Entity
public class HR {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String Name;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@OneToOne
	private Userinfo userinfo;
	
}
