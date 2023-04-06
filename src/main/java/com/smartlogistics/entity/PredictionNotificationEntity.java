package com.smartlogistics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity(name = "Predection_Table")
public class PredictionNotificationEntity {

	@Id
	@Column(name = "notification_Id")
	@GeneratedValue
	private Long notificationId;

	@Column(name = "battery_Percentage")
	private double batteryPercentage;

	@Column(name = "temparature")
	private double temparature;

	@Column(name = "status")
	private String status;

	@Column(name = "message")
	private String message;

}
