package com.smartlogistics.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotificationResponseDTO {

	private String boxId;
	private String equipmentId;
	private String warehouseId;
    private String warehouseLoc;
    private NotificationDTO notificationDTO;
	
}
