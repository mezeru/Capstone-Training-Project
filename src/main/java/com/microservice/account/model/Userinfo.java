package com.microservice.account.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.microservice.account.enums.RoleType;

@Entity
public class Userinfo implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7158010081197621341L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false, length = 512)
	private String password;
	
	private RoleType role;
	
	

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

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}
	
	

	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userinfo(int id, String username, String password, RoleType role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", username=" + username + ", password=" + password+"]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//Role to Authority and to GrantedAuthority
		
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role.toString());
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(sga);
		return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
