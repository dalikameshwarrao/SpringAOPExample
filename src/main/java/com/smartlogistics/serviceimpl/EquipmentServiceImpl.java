package com.smartlogistics.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlogistics.dto.AccessPointDTO;
import com.smartlogistics.dto.ApListDTO;
import com.smartlogistics.dto.EquipListDTO;
import com.smartlogistics.dto.EquipmentDTO;
import com.smartlogistics.dto.RootDTO;
import com.smartlogistics.entity.AccessPointEntity;
import com.smartlogistics.entity.AssetEntity;
import com.smartlogistics.entity.WarehouseEntity;
import com.smartlogistics.repository.AccessPointRepo;
import com.smartlogistics.repository.EquipmentRepo;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.service.AccessPointDetailService;
import com.smartlogistics.service.EquipmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentRepo EquipmentRepo;

	@Autowired
	private WarehouseRepository warehouseRepo;

	@Autowired
	private AccessPointRepo accessPointRepo;

	@Autowired
	private AccessPointDetailService accessPointDetailService;

	@Override
	public RootDTO getEquipmentDetail(String warehouseId, String assetType) {
		// Long warehouseId = Long.valueOf(dto.getWarehouseId());
		List<AssetEntity> equipmentDetails = EquipmentRepo.getEquipmentDetail(warehouseId, assetType);
		WarehouseEntity warehouseDetail = warehouseRepo.findByWarehouseId(warehouseId).get(0);
		List<AccessPointEntity> aPList = accessPointDetailService.getAccessPointDetailsByWarehouseId(warehouseId);
		Integer apListCount = aPList.size();
		List<ApListDTO> AccessPointListDTO = new ArrayList<ApListDTO>();
		List<EquipListDTO> eqipModelList = new ArrayList<EquipListDTO>();
		RootDTO rootDTO = new RootDTO();
		AccessPointDTO AccessPointDTO = new AccessPointDTO();
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		// int equipmentcount= EquipmentRepo.getCountofEquipment(warehouseId);
		equipmentDTO.setCount(equipmentDetails.size());
		for (AssetEntity equipmentfromDb : equipmentDetails) {
			EquipListDTO equipListDTO = new EquipListDTO();
			equipListDTO.setEquipId(equipmentfromDb.getAssetId());
			equipListDTO.setTrackId(equipmentfromDb.getTrackerId());
			equipListDTO.setEquip_type(equipmentfromDb.getEquipmentType());
			equipListDTO.setTrack_status(equipmentfromDb.getTrackerStatus());
			equipListDTO.setTrack_battery(equipmentfromDb.getTrackerBattery());
			equipListDTO.setEquip_utilization(equipmentfromDb.getEquipmentUtilization());
			equipListDTO.setTrack_temp(equipmentfromDb.getTemperature());
			equipListDTO.setEuip_operator(equipmentfromDb.getEquipmentOperator());
			equipListDTO.setEquip_location(equipmentfromDb.getAssetLocation());
			equipListDTO.setEquip_state(equipmentfromDb.getEquipmentState());
			equipListDTO.setMake(equipmentfromDb.getMake());
			equipListDTO.setCategory(equipmentfromDb.getCategory());
			equipListDTO.setLast_updated(equipmentfromDb.getLastUpdate());
			equipListDTO.setGeo_name(equipmentfromDb.getGeofenceName());
			equipListDTO.setGeo_type(equipmentfromDb.getGeofenceType());
			equipListDTO.setGeo_lat(equipmentfromDb.getGeoLatitude());
			equipListDTO.setGeo_lng(equipmentfromDb.getGeoLongitude());
			equipListDTO.setGeo_radius(equipmentfromDb.getRadius());
			equipListDTO.setOut_geo(equipmentfromDb.getOutsideGeofence());
			equipListDTO.setBack_geo(equipmentfromDb.getBackToGeofence());
			eqipModelList.add(equipListDTO);

		}

		AccessPointDTO.setCount(apListCount);

		// rootDTO.setAccess_point(apListDTO);
		for (AccessPointEntity entity : aPList) {
			ApListDTO apListDTO = new ApListDTO();
			apListDTO.setAp_id(entity.getAccessPointId());
			apListDTO.setAp_loc(entity.getAccessPointLocation());
			apListDTO.setStatus(entity.getStatus());
			apListDTO.setNo_of_tag(entity.getNoOfLabelConnected());
			AccessPointListDTO.add(apListDTO);
		}
		AccessPointDTO.setAp_list(AccessPointListDTO);

		rootDTO.setWarehouseId(warehouseDetail.getWarehouseId());
		rootDTO.setWarehouseLoc(warehouseDetail.getLocation());
		rootDTO.setAccess_point(AccessPointDTO);
		equipmentDTO.setEquipList(eqipModelList);
		rootDTO.setEquipment(equipmentDTO);

		return rootDTO;
	}

}
