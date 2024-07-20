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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}


	public Userinfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	public Employee(int id, String name, double salary, int points, Manager manager, Userinfo userinfo) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.points = points;
		this.manager = manager;
		this.userinfo = userinfo;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
