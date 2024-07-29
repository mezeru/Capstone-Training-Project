package com.microservice.account.dto;

import com.microservice.account.enums.JobType;

public class EmployeeManagerDto {
	private int id;
	private String name;
	private double salary;
	private JobType jobTitle;

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

	public JobType getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobType jobTitle) {
		this.jobTitle = jobTitle;
	}



}