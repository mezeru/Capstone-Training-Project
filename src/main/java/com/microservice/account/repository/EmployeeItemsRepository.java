package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice.account.model.EmployeeItems;
import com.microservice.account.model.Items;


public interface EmployeeItemsRepository extends JpaRepository<EmployeeItems, Integer>{

	@Query("SELECT ei.item FROM EmployeeItems ei WHERE ei.employee.id = :employeeId")
    List<Items> findItemsByEmployeeId(int employeeId);

}
