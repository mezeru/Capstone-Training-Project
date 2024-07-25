package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.account.model.PointsReward;

@Repository
public interface PointsRewardRepository extends JpaRepository<PointsReward, Integer> {

	List<PointsReward> getByManagerId(int managerId);

	List<PointsReward> getByEmployeeId(int employeeId);

}
