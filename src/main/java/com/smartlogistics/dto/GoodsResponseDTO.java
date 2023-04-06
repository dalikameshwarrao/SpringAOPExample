package com.smartlogistics.dto;

import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsResponseDTO {

	private Long assetId;
	private Long trackerId;
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
	private Date connected;
	private String statgeOfBox;
	private String geofenceType;
	private String geofenceName;
	private Double geoLatitude;
	private Double geoLongitude;
	private Double radius;
	private Boolean outsideGeofence;
	private Boolean backToGeofence;
	private Date lastUpdate;
	private String make;
	private String dimension;

}
