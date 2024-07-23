package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

	List<Employee> findByManagerId(int managerId);

	Employee getByUserinfoId(int userinfoId);

}
