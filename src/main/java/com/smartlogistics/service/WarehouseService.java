package com.smartlogistics.service;

import java.util.List;

import com.smartlogistics.dto.WarehouseRequestDTO;
import com.smartlogistics.entity.WarehouseEntity;

public interface WarehouseService {

	
	public WarehouseEntity registerWarehouseDetails(WarehouseRequestDTO  warehouseRequestDTO);
	
	public List<WarehouseEntity> getListAllWarehouses();
	
	public void updateWarehouseDetails(WarehouseEntity entity);

}
