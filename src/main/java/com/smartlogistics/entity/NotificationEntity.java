package com.smartlogistics.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "Notification")
@Data
public class NotificationEntity {

	
	@Id
	@Column(name = "notification_id")
	private Long notificationId;
	
	@Column(name= "asset_id")
	private Long assetId;
	
	@Column(name = "asset_type")
	private String assetType;
	

	@Column(name = "equipment_type")
	private String equipmentType;
	

	@Column(name = "equipment_utilization")
	private Double equipmentUtilization;
	

	@Column(name = "event_date_and_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventDateAndTime;
	

	@Column(name = "notification_type")
	private String notificationType;
	

	@Column(name = "racker_details")
	private String rackerDetails;
	

	@Column(name = "reason")
	private String reason;
	

	@Column(name = "temperature")
	private Double temperature;
	

	@Column(name = "tracker_battery")
	private Double trackerBattery;
	

	@Column(name= "tracker_id")
	private Long trackerId;
	

	@Column(name = "tracker_status")
	private String trackerStatus;
	

	@Column(name= "warehouse_id")
	private Long warehouseId;
	
	@Column(name = "warehouse_loc")
	private String warehouseLoc;
	

	@Column(name = "equip_location")
	private String equipmentLocation;
	
	
}
