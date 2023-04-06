package com.smartlogistics.service;

import java.util.List;

import com.smartlogistics.dto.AccessPointNewDTO;
import com.smartlogistics.entity.AccessPointEntity;

public interface AccessPointDetailService {

	List<AccessPointEntity> getAccessPointDetailsByWarehouseId(String warehouseId);

	public AccessPointEntity saveAccessPointDetails(AccessPointEntity accessPointEntity);

	public AccessPointEntity updatedAccessDetails(AccessPointEntity accessEntity);
}
