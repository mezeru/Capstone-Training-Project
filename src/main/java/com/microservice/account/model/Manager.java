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
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String Name;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
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

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
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
		this.role = role;
		this.userinfo = userinfo;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
