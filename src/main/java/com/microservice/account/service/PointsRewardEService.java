package com.microservice.account.service;

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
	
}
