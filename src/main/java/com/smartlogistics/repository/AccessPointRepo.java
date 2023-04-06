package com.smartlogistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartlogistics.entity.AccessPointEntity;

@Repository
public interface AccessPointRepo extends JpaRepository<AccessPointEntity, Long> {
	
	static final String QUERY_TO_GET_ACCESSPOINT_DETAILS_BY_WAREHOUSEID = "SELECT * from Access_Point  "
			+ " where warehouse_id=:warehouseId";
	
	static final String QUERY_TO_GET_ACCESSPOINT_DETAILS_BY_ACCESSPOINTID = "SELECT * from Access_Point  "
			+ " where access_point_id=:accessPointId";
	
	@Query(value = QUERY_TO_GET_ACCESSPOINT_DETAILS_BY_WAREHOUSEID,nativeQuery = true)
	List<AccessPointEntity> findByWarehouseId(String warehouseId);

	@Query(value = QUERY_TO_GET_ACCESSPOINT_DETAILS_BY_ACCESSPOINTID,nativeQuery = true)
	AccessPointEntity findByaccessPointId(Long accessPointId);
}
