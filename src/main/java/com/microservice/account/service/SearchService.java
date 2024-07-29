package com.microservice.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.account.dto.EmployeeManagerDto;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Manager;

@Service
public class SearchService {

	public List<EmployeeManagerDto> convertToDto(List<Employee> listEmp, 
			List<Manager> listMng) {
		
		List<EmployeeManagerDto> listDto = new ArrayList<>(); 
		listEmp.stream().forEach(e->{
			EmployeeManagerDto dto = new EmployeeManagerDto(); 
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setSalary(e.getSalary());
			dto.setJobTitle(e.getJobtype());
			listDto.add(dto);
		});
		
		listMng.stream().forEach(m->{
			EmployeeManagerDto dto = new EmployeeManagerDto(); 
			dto.setId(m.getId());
			dto.setName(m.getName());
			listDto.add(dto);
		});
		return listDto;
	}

}