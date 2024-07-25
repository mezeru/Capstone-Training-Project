package com.microservice.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.PointsReward;
import com.microservice.account.repository.PointsRewardRepository;

@Service
public class PointsRewardEService {
	
	@Autowired
	private PointsRewardRepository pointsRewardsRepository;
	

	public PointsReward addPoints(PointsReward pointsRewarded) {
		
		return pointsRewardsRepository.save(pointsRewarded);
		
	}


	public List<PointsReward> getHistoryByManager(int managerId) {
		
		return pointsRewardsRepository.getByManagerId(managerId);
		
	}


	public List<PointsReward> getHistoryByEmployee(int employeeId) {
		
		return pointsRewardsRepository.getByEmployeeId(employeeId);	
		
	}
	
}
