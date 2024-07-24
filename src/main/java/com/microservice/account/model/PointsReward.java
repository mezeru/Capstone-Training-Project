package com.microservice.account.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class PointsReward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int points;
	
	@CreationTimestamp
    private LocalDateTime timestamp;
	
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
	
	

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
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

	
	

	public PointsReward(int id, int points, LocalDateTime timestamp, Employee employee, Manager manager,
			String review) {
		super();
		this.id = id;
		this.points = points;
		this.timestamp = timestamp;
		this.employee = employee;
		this.manager = manager;
		this.review = review;
	}

	public PointsReward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
