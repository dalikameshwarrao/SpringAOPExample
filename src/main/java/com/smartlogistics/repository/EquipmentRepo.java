package com.smartlogistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartlogistics.entity.AssetEntity;

@Repository
public interface EquipmentRepo extends JpaRepository<AssetEntity, Long> {
	
	static final String QUERY_FOR_EQUIPMENT_DETAILS = "SELECT * from Asset "
    		+ " where warehouse_id=:warehouseId and asset_type=:assetType ";
	
	/*
	 * static final String QUERY_FOR_GET_EQUIPMENT_COUNT =
	 * "SELECT count(distinct equipment_count) from Warehouse " +
	 * " where warehouse_id=:warehouseId ";
	 */
	/*
	 * @Query(value =QUERY_FOR_GET_EQUIPMENT_COUNT,nativeQuery = true) public
	 * Integer getCountofEquipment(Long warehouseId);
	 */
	
	@Query(value =QUERY_FOR_EQUIPMENT_DETAILS,nativeQuery = true)
    public List<AssetEntity> getEquipmentDetail(String warehouseId, String assetType);
}
