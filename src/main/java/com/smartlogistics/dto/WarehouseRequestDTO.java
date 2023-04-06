package com.smartlogistics.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WarehouseRequestDTO {
	
	@NotEmpty(message="warehouseName is Mandatory")
	private String warehouseName;
	
	@NotEmpty(message="location is Mandatory")
	private String location;
	
	private Integer goodsCount;
	
	private Integer equipmentCount;
	
	private Integer accessPointCount;
	
	private Date lastUpdate;


}
