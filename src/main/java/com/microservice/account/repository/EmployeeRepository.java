package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice.account.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

	List<Employee> findByManagerId(int managerId);

	Employee getByUserinfoId(int userinfoId);

	@Query("select e from Employee e where e.name LIKE %?1%")
	List<Employee> getEmployeeByName(String searchName);

}
