package com.smartlogistics.controllers;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogistics.dto.RootDTO;
import com.smartlogistics.service.EquipmentService;
import com.smartlogistics.util.Constants;


@RestController
@RequestMapping(path = "/smartlogistics")
public class EquipmentController {
	@Autowired
	EquipmentService equipmentService;

	@GetMapping("/v1/getEquipmentDetail/{warehouseId}")
	public ResponseEntity<?> getEquipmentDetails(@PathVariable String warehouseId ) throws ValidationException{
		if(warehouseId==null || warehouseId.isEmpty() || warehouseId.isBlank()) {
			throw new ValidationException("Please provide valid warehouseId");
		}
		RootDTO rootDTO = new RootDTO();
		rootDTO=equipmentService.getEquipmentDetail(warehouseId, Constants.EQUIPMENT_TYPE);
		return new ResponseEntity<>(rootDTO,HttpStatus.OK);
		
	}
}
