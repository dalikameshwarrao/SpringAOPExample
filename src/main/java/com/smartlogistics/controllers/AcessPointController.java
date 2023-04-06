package com.smartlogistics.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogistics.dto.AccessPointNewDTO;
import com.smartlogistics.dto.AccessPointTagDTO;
import com.smartlogistics.entity.AccessPointEntity;
import com.smartlogistics.entity.AccessPointTagEntity;
import com.smartlogistics.entity.AssetEntity;
import com.smartlogistics.entity.WarehouseEntity;
import com.smartlogistics.repository.AccessPointRepo;
import com.smartlogistics.repository.AssetRepo;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.service.AccessPointDetailService;
import com.smartlogistics.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/smartlogistics")
public class AcessPointController {

	@Autowired
	private AccessPointDetailService accessPointDetailService;
	@Autowired
	private AccessPointRepo accessPointRepo;
	@Autowired
	private AssetRepo assetRepo;
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	
	@PostMapping("/insertaccessPoint")
	public ResponseEntity<AccessPointEntity> registerAccessPointDetails(
			@RequestBody AccessPointNewDTO accessPointNewDTO) throws ValidationException {

		AccessPointEntity pointEntity = accessPointRepo.findByaccessPointId(accessPointNewDTO.getAccessPointId());
		if (pointEntity == null) {
			AccessPointEntity accessPointEntity = new AccessPointEntity();
			accessPointEntity.setAccessPointId(accessPointNewDTO.getAccessPointId());
			accessPointEntity.setAccessPointLocation(accessPointNewDTO.getAccessPointLocation());
			accessPointEntity.setAccessPointName(accessPointNewDTO.getAccessPointName());
			accessPointEntity.setNoOfLabelConnected(accessPointNewDTO.getNoOfLabelConnected());
			accessPointEntity.setStatus(accessPointNewDTO.getStatus());
			accessPointEntity.setWarehouseId(accessPointNewDTO.getWarehouseId());
			List<AccessPointTagEntity> accessPointTagEntityList = new ArrayList<>();
			if (accessPointNewDTO.getAccessPointId() != null) {
				List<AccessPointTagDTO> accessPointTagDTOList = accessPointNewDTO.getTags();
				for (AccessPointTagDTO accessPointTagDTO : accessPointTagDTOList) {
					AccessPointTagEntity accessPointTagEntity = new AccessPointTagEntity();
					accessPointTagEntity.setAccessPointTagId(accessPointTagDTO.getAccessPointTagId());
					accessPointTagEntity.setTracker_Id(accessPointTagDTO.getTrackerId());
					accessPointTagEntityList.add(accessPointTagEntity);
					//tag count logic
					
					//Based on tracker_id pulling the list of asset type & updating in warehouse table
					if (Optional.ofNullable(accessPointTagDTO.getTrackerId()).isPresent()) {
						//based on tracker id pulling asset information
						List<AssetEntity> assetList = assetRepo.findByTrackerId(accessPointTagDTO.getTrackerId());
						Long goodsCount, equipmentCount = 0L;			
						goodsCount =  assetList.stream().filter(asset -> asset.getAssetType().equalsIgnoreCase(Constants.GOODS_TYPE)).count();
						equipmentCount = assetList.stream().filter(asset -> asset.getAssetType().equalsIgnoreCase(Constants.EQUIPMENT_TYPE)).count();
						WarehouseEntity data = warehouseRepository.findByWarehouseId(accessPointNewDTO.getWarehouseId()).get(0);
						data.setGoodsCount((int) (data.getGoodsCount()+ goodsCount));
						data.setEquipmentCount((int) (data.getEquipmentCount()+ equipmentCount));
						warehouseRepository.save(data);
					}				
					
									
				}
				accessPointEntity.setTags(accessPointTagEntityList);
				accessPointEntity.setTageCount(accessPointTagEntityList.size());
				pointEntity = accessPointDetailService.saveAccessPointDetails(accessPointEntity);
			}
			
		}else {
			throw new ValidationException("accessPointId already exists");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/updateaccessPoint")
	public ResponseEntity<Void> updatedAccesstDetails(@Valid @RequestBody AccessPointEntity entity) {
		AccessPointEntity accessPointEntity = accessPointDetailService.updatedAccessDetails(entity);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}