package com.smartlogistics.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.smartlogistics.entity.AccessPointTagEntity;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AccessPointNewDTO {

	private Long accessPointId;

	private String accessPointName;

	private Integer noOfLabelConnected;

	private String status;

	private String accessPointLocation;

	private String warehouseId;
	
	private List<AccessPointTagDTO> tags;
}
