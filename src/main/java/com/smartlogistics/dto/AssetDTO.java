package com.smartlogistics.dto;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AssetDTO {

    private Long assetId;
	
	private String assetType;
	
	private String goodsType;
	
	private Long warehouseId;
	
	private String assetName;
	
	private Long trackerId;
	
	private String trackerName;
	
	private String trackerStatus;
	
	private Double trackerBattery;
	
	private Double temperature;
	
	private Double noOfUnit;
	
	private String source;
	
	private String category;
	
	private Date packagePickedUp;
	
	private Date initialScan;
	
	private Date staggingAndTagging;
	
	private Date putaway;
	
	private String assetLocation;
	
	private Date connected;
	
	private String statgeOfBox;
	
	private String geofenceType;
	
	private String geofenceName;
	
	private Double geoLatitude;
	
	private Double geoLongitude;
	
	private Double radius;
	
	private Boolean outsideGeofence;
	
	private Boolean backToGeofence;
	
	private String equipmentType;
	
	private Double equipmentUtilization;
	
	private String equipmentState;
	
	private String equipmentOperator;
	
	private LocalTime lastUpdate;
	
	private String make;
	
	private String dimension;

	
}
