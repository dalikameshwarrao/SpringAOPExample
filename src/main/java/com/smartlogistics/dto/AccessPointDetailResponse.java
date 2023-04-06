package com.smartlogistics.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.smartlogistics.entity.AccessPointEntity;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessPointDetailResponse {
	
	private Integer count;
	private List<AccessPointEntity> ap_list;

}
