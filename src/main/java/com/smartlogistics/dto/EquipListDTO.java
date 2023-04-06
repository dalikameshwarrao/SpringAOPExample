package com.smartlogistics.dto;

import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EquipListDTO {
	public Long equipId;
    public Long trackId;
    public String equip_type;
    public String track_status;
    public Double track_battery;
    public Double equip_utilization;
    public double track_temp;
    public String euip_operator;
    public String equip_location;
    public String equip_state;
    public String make;
    public String category;
    public Date last_updated;
    public String geo_name;
    public String geo_type;
    public double geo_lat;
    public double geo_lng;
    public double geo_radius;
    public boolean out_geo;
    public boolean back_geo;
}
