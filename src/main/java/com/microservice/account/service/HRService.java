package com.microservice.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.dto.EmployeeDto;
import com.microservice.account.dto.ManagerDto;
import com.microservice.account.model.Employee;
import com.microservice.account.model.HR;
import com.microservice.account.model.Manager;
import com.microservice.account.repository.EmployeeRepository;
import com.microservice.account.repository.HRRepository;
import com.microservice.account.repository.ManagerRepository;

@Service
public class HRService {
	
	@Autowired
	public HRRepository hrRepository;
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public ManagerRepository managerRepository;

	public HR addHr(HR hr) {
		return hrRepository.save(hr);
		
	}

	public HR getHrByUserID(int userinfoId) {
		
		return hrRepository.getByUserinfoId(userinfoId);
		
	}

	public List<ManagerDto> getAllManagerWithEmployee() {
		// TODO Auto-generated method stub
		
			List<Employee> listEmployee = employeeRepository.findAll();
			List<Manager> listManager = managerRepository.findAll();

			List<ManagerDto> mDtoList = new ArrayList<>();

			listManager.stream().forEach(m->{
				ManagerDto mDto = new ManagerDto();
				mDto.setId(m.getId());
				mDto.setName(m.getName());

				List<Employee> filteredList 
						= listEmployee
								.stream()
								.filter(e->e.getManager().getId() == m.getId())
								.collect(Collectors.toList());

				List<EmployeeDto> listEmployeeDto = new ArrayList<>();
				filteredList.stream().forEach(emp->{
					EmployeeDto eDto = new EmployeeDto(); 
					eDto.setId(emp.getId());
					eDto.setName(emp.getName());
					eDto.setSalary(emp.getSalary());
					listEmployeeDto.add(eDto);
				});
				mDto.setEmployees(listEmployeeDto);
				mDtoList.add(mDto);
			});
			return mDtoList;
		
	}
	
	
	

}
