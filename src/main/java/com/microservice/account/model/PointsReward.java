package com.microservice.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PointsReward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int points;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Manager manager;
	
	private String review;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}
	

	public String getReview() {
		return review;
	}
	
	

	public void setReview(String review) {
		this.review = review;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	

	public PointsReward(int id, int points, Employee employee, Manager manager, String review) {
		super();
		this.id = id;
		this.points = points;
		this.employee = employee;
		this.manager = manager;
		this.review = review;
	}

	public PointsReward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
