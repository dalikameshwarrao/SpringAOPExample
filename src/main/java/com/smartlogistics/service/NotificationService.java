package com.smartlogistics.service;

import java.util.List;


import com.smartlogistics.dto.NotificationDTO;
import com.smartlogistics.dto.NotificationResponseDTO;

public interface NotificationService {

	NotificationResponseDTO getAllnotificationsByType(Long warehouseId, Long assetId, String type);

}
