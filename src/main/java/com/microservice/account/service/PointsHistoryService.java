package com.microservice.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.dto.PointsHistoryDto;
import com.microservice.account.model.EmployeeItems;
import com.microservice.account.model.PointsReward;

@Service
public class PointsHistoryService {
	
	@Autowired
	private PointsRewardEService pointsRewardService;
	
	@Autowired
	private EmployeeItemsService employeeItemsService;
	
	public List<PointsHistoryDto> getPointsHistory(int employeeId){
		
		
		List<PointsReward> pointsRewards = pointsRewardService.getHistoryByEmployee(employeeId);
		List<EmployeeItems> employeeItems = employeeItemsService.getItemsbyEmployee(employeeId);
		
		 List<PointsHistoryDto> itemDto = employeeItems.stream().map(reward -> {
            PointsHistoryDto dto = new PointsHistoryDto();
            dto.setItemName(reward.getItem().getName());
            dto.setPoints(reward.getItem().getPoints());
            dto.setTimestamp(reward.getTimestamp());
            dto.setDesc(reward.getItem().getDescription());
            return dto;
        }).collect(Collectors.toList());
		 
		 List<PointsHistoryDto> rewardDto = pointsRewards.stream().map(reward -> {
	            PointsHistoryDto dto = new PointsHistoryDto();
	            dto.setManagerName(reward.getManager().getName());
	            dto.setPoints(reward.getPoints());
	            dto.setTimestamp(reward.getTimestamp());
	            dto.setDesc(reward.getReview());
	            return dto;
	        }).collect(Collectors.toList());
		 
		 itemDto.addAll(rewardDto);

	        return itemDto;
		
	}

}
