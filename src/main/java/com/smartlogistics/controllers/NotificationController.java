package com.smartlogistics.controllers;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogistics.dto.NotificationRequestDTO;
import com.smartlogistics.dto.NotificationResponseDTO;
import com.smartlogistics.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/smartlogistics")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@PostMapping("/v1/getNotification")
	public NotificationResponseDTO getNotificationDetails( @Valid @RequestBody NotificationRequestDTO dto ) throws ValidationException  {
				if (dto.getWarehouseId()!=null && dto.getType()!=null && dto.getAssetId()!=null ) {
						Long warehouseId = Long.valueOf(dto.getWarehouseId());
						Long assetId = Long.valueOf(dto.getAssetId());
						String type = dto.getType();
						return notificationService.getAllnotificationsByType(warehouseId,assetId,type);
	  }else {
		  		throw new ValidationException("Please provide valid input..");

	  }
}
	
	
}