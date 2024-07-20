package com.microservice.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
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

	public PointsReward(int id, int points, Employee employee, Manager manager) {
		super();
		this.id = id;
		this.points = points;
		this.employee = employee;
		this.manager = manager;
	}

	public PointsReward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
