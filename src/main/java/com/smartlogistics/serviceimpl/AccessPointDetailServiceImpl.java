package com.smartlogistics.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlogistics.dto.AccessPointNewDTO;
import com.smartlogistics.entity.AccessPointEntity;
import com.smartlogistics.repository.AccessPointRepo;
import com.smartlogistics.service.AccessPointDetailService;

@Service
public class AccessPointDetailServiceImpl implements AccessPointDetailService {

	@Autowired
	private AccessPointRepo accessPointRepo;

	@Override
	public List<AccessPointEntity> getAccessPointDetailsByWarehouseId(String warehouseId) {
		return accessPointRepo.findByWarehouseId(warehouseId);
	}

	@Override
	public AccessPointEntity saveAccessPointDetails(AccessPointEntity accessPointEntity) {
		return accessPointRepo.save(accessPointEntity);
	}

	public AccessPointEntity updatedAccessDetails(AccessPointEntity accessEntity) {
		return accessPointRepo.save(accessEntity);

	}

	//@Override
	/*public AccessPointEntity updateAccessPointDetails(AccessPointNewDTO accessPointNewDTO,
			AccessPointEntity accessPointEntity) {
		// TODO Auto-generated method stub
		return accessPointRepo.save(accessPointEntity);
	}*/

	/*
	 * @Override public AccessPointEntity updateAccessPointDetails(AccessPointNewDTO
	 * accessPointNewDTO, AccessPointEntity accessPointEntity) { // TODO
	 * Auto-generated method stub return accessPointRepo.save(accessPointEntity); }
	 */

	/*
	 * @Override public AccessPointEntity updateAccessPointDetails(AccessPointNewDTO
	 * accessPointNewDTO,AccessPointEntity accessPointEntity) { if
	 * (accessPointNewDTO.getAccessPointId() != null ) if(
	 * accessPointNewDTO.getNoOfLabelConnected()!=null) {
	 * accessPointEntity.setNoOfLabelConnected(accessPointNewDTO.
	 * getNoOfLabelConnected()); }
	 * if(accessPointNewDTO.getAccessPointLocation()!=null) {
	 * accessPointEntity.setAccessPointLocation(accessPointNewDTO.
	 * getAccessPointLocation()); } if(accessPointNewDTO.getAccessPointName()!=null)
	 * {
	 * accessPointEntity.setAccessPointName(accessPointNewDTO.getAccessPointName());
	 * } if(accessPointNewDTO.getStatus()!=null) {
	 * accessPointEntity.setStatus(accessPointNewDTO.getStatus()); }
	 * accessPointRepo.save(accessPointEntity); return accessPointEntity; }
	 */

}
