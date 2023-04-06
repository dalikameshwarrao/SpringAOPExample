package com.smartlogistics.service;

import com.smartlogistics.dto.ChangeGeofenceDTO;
import com.smartlogistics.entity.AssetEntity;

public interface AssetService {
	
	
	public AssetEntity saveAssetDetails(AssetEntity assetEntity);

	public AssetEntity changeGeofenceConfig(ChangeGeofenceDTO changeGeofenceDTO);

}
