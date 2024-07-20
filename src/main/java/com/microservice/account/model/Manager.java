package com.microservice.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.microservice.account.enums.RoleType;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String Name;

	
	@OneToOne
	private Userinfo userinfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Manager(int id, String name, RoleType role, Userinfo userinfo) {
		super();
		this.id = id;
		Name = name;
		this.userinfo = userinfo;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
