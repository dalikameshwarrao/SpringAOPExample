package com.smartlogistics.service;

import java.util.List;

import com.smartlogistics.entity.AssetEntity;

public interface GoodDetailService {
	
	List<AssetEntity> getGoodDetailByWarehouseId(String warehouseId);

}
