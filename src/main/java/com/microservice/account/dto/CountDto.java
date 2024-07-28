package com.microservice.account.dto;

public class CountDto {
	
	 private long employeeCount;
	 private long managerCount;
	public long getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(long employeeCount) {
		this.employeeCount = employeeCount;
	}
	public long getManagerCount() {
		return managerCount;
	}
	public void setManagerCount(long managerCount) {
		this.managerCount = managerCount;
	}
	public CountDto(long employeeCount, long managerCount) {
		super();
		this.employeeCount = employeeCount;
		this.managerCount = managerCount;
	}
	public CountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
	 

}
