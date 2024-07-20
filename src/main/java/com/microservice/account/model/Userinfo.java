package com.microservice.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.microservice.account.enums.RoleType;

@Entity
public class Userinfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false, length = 512)
	private String password;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	public Userinfo(int id, String username, String password, RoleType role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", username=" + username + ", password=" + password+"]";
	}
	
	
	

}
