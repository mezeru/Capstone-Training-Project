package com.microservice.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Items item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public EmployeeItems(int id, Employee employee, Items item) {
		super();
		this.id = id;
		this.employee = employee;
		this.item = item;
	}

	public EmployeeItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
