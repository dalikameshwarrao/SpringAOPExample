package com.smartlogistics.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogistics.entity.WarehouseEntity;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.service.WarehouseService;
import com.smartlogistics.service.NotificationService;
import com.smartlogistics.dto.NotificationRequestDTO;
import com.smartlogistics.dto.NotificationResponseDTO;
import com.smartlogistics.dto.WarehouseRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/smartlogistics")
public class WarehouseController {

	@Autowired
	private WarehouseService service;

	@Autowired
	private WarehouseRepository repository;
	
	@Autowired
	NotificationService notificationService;

	@PostMapping("/insertWarehouse")
	public ResponseEntity<WarehouseEntity> insertWarehouse(@Valid @RequestBody WarehouseRequestDTO warehouseRequestDTO) 
	{
		log.info("In WarehouseController...insertWarehouse() started");
		try {
			log.info("In WarehouseController...insertWarehouse() registred");
			WarehouseEntity entity = service.registerWarehouseDetails(warehouseRequestDTO);
			return new ResponseEntity<>(entity, HttpStatus.OK);

		} catch (Exception e) {
			log.error("In WarehouseController...insertWarehouse() error message");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	@GetMapping("/getAllWarehouses")
	public ResponseEntity<List<WarehouseEntity>> getListOfWarehouses()
	{
		log.info("In WarehouseController...getListOfWarehouses() started");
		try {
			
			log.info("In WarehouseController...getListOfWarehouses() registred");
			List<WarehouseEntity> warehouses=service.getListAllWarehouses();
			return new ResponseEntity<>(warehouses,HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.error("In WarehouseController...insertWarehouse() error message");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/updateWarehouse")
	public ResponseEntity<?> updateDetails(@Valid @RequestBody WarehouseEntity entity)
	{
		try {
			
			service.updateWarehouseDetails(entity);
			return  new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
