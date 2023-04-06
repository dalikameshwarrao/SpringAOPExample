package com.smartlogistics.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RootDTO {
	public String warehouseId;
    public String warehouseLoc;
    public AccessPointDTO access_point;
    public EquipmentDTO equipment;
}
