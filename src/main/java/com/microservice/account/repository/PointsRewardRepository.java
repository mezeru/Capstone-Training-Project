package com.microservice.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.PointsReward;

public interface PointsRewardRepository extends JpaRepository<PointsReward, Integer> {

}
