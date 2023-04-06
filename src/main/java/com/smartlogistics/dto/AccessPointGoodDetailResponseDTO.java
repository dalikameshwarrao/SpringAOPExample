package com.smartlogistics.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessPointGoodDetailResponseDTO {
	
	private String warehouseId;
	private String warehouseLoc;
	
	private AccessPointDetailResponse access_point;
	private GoodDetailResponse goods;

}
