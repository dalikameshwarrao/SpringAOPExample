package com.smartlogistics.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Table(name = "Asset")
@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetEntity {
	@Id
	@Column(name = "asset_id")
	private Long assetId;
	
	@Column(name = "asset_type")
	private String assetType;
	
	private String goodsType;
	
	@Column(name = "warehouse_id")
	private Long warehouseId;
	
	@Column(name = "asset_name")
	private String assetName;
	
	@Column(name = "tracker_id")
	private Long trackerId;
	
	@Column(name = "tracker_name")
	private String trackerName;
	
	@Column(name = "tracker_status")
	private String trackerStatus;
	
	@Column(name = "tracker_battery")
	private Double trackerBattery;
	
	@Column(name = "temperature")
	private Double temperature;
	
	@Column(name = "no_of_unit")
	private Double noOfUnit;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "package_picked_up")
	private Date packagePickedUp;
	
	@Column(name = "initial_scan")
	private Date initialScan;
	
	@Column(name = "stagging_and_tagging")
	private Date staggingAndTagging;
	
	@Column(name = "putaway")
	private Date putaway;
	
	@Column(name = "asset_location")
	private String assetLocation;
	
	@Column(name = "connected")
	private Date connected;
	
	@Column(name = "stage_of_box")
	private String statgeOfBox;
	
	@Column(name = "geofence_type")
	private String geofenceType;
	
	@Column(name = "geofence_name")
	private String geofenceName;
	
	@Column(name = "geo_latitude")
	private Double geoLatitude;
	
	@Column(name = "geo_longitude")
	private Double geoLongitude;
	
	@Column(name = "radius")
	private Double radius;
	
	@Column(name = "outside_geofence")
	private Boolean outsideGeofence;
	
	@Column(name = "back_to_geofence")
	private Boolean backToGeofence;
	
	@Column(name = "equipment_type")
	private String equipmentType;
	
	@Column(name = "equipment_utilization")
	private Double equipmentUtilization;
	
	@Column(name = "equipment_state")
	private String equipmentState;
	
	@Column(name = "equipment_operator")
	private String equipmentOperator;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "dimension")
	private String dimension;
	

}
