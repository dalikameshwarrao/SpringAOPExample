package com.smartlogistics.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlogistics.dto.WarehouseRequestDTO;
import com.smartlogistics.entity.WarehouseEntity;
import com.smartlogistics.exception.WarehouseRuntimeException;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.service.WarehouseService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepository repository;


	@Override
	public WarehouseEntity registerWarehouseDetails(WarehouseRequestDTO warehouseRequestDTO) {
		log.info("In WarehouseserviceImpl...save methode() is started");
		try {
			log.info("In WarehouseserviceImpl...save methode() is registred");
			WarehouseEntity entity = new WarehouseEntity();
			entity.setWarehouseName(warehouseRequestDTO.getWarehouseName());
			entity.setLocation(warehouseRequestDTO.getLocation());
			entity.setLastUpdate(warehouseRequestDTO.getLastUpdate());
			entity.setGoodsCount(warehouseRequestDTO.getGoodsCount());
			entity.setEquipmentCount(warehouseRequestDTO.getEquipmentCount());
			entity.setAccessPointCount(warehouseRequestDTO.getAccessPointCount());
			entity=repository.save(entity);
			return entity;
			
		} catch (Exception e) {
			log.error("In WarehouseserviceImpl...exception message");
			throw new WarehouseRuntimeException(e.getMessage());
		}	}


	@Override
	public List<WarehouseEntity> getListAllWarehouses() {
		
		
		return repository.findAll();
	}


	@Override
	public void updateWarehouseDetails(WarehouseEntity entity) {

		repository.save(entity);
	}

}
