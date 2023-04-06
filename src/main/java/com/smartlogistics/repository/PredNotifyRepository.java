package com.smartlogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartlogistics.entity.PredictionNotificationEntity;

public interface PredNotifyRepository extends JpaRepository<PredictionNotificationEntity, Long> {

}
