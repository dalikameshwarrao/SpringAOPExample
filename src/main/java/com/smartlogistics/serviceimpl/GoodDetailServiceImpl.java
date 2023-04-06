package com.smartlogistics.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlogistics.entity.AssetEntity;
import com.smartlogistics.repository.AssetRepo;
import com.smartlogistics.service.GoodDetailService;

@Service
public class GoodDetailServiceImpl implements GoodDetailService  {
	
	@Autowired
	private AssetRepo assetRepo;

	@Override
	public List<AssetEntity> getGoodDetailByWarehouseId(String warehouseId) {
		 
		return assetRepo.findByWarehouseId(warehouseId);
	}

}
