package com.smartlogistics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartlogistics.dto.RootDTO;

@Service
public interface EquipmentService {
	public RootDTO getEquipmentDetail(String warehouseId, String assetType);
}
