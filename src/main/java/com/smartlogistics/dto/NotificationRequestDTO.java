package com.smartlogistics.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationRequestDTO {
		
	    @NotEmpty(message="please check input")
		private String warehouseId;
	    @NotEmpty(message="please check input")
		private String type;
	    @NotEmpty(message="please check input")
		private String assetId;
	
}
