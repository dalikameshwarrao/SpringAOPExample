package com.smartlogistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartlogistics.entity.AssetEntity;

@Repository
public interface AssetRepo extends JpaRepository<AssetEntity, Long> {
	
	static final String QUERY_TO_GET_GOODS_DETAILS_BY_WAREHOUSEID ="select * from Asset where warehouse_id = :warehouseId and asset_type = 'Goods'";

	@Query(value = QUERY_TO_GET_GOODS_DETAILS_BY_WAREHOUSEID,nativeQuery = true)
	List<AssetEntity> findByWarehouseId(String warehouseId);
	
	static final String QUERY_TO_GET_GOODS_DETAILS_BY_TRACKERID ="select * from Asset where tracker_id = :trackerId ";

	@Query(value = QUERY_TO_GET_GOODS_DETAILS_BY_TRACKERID,nativeQuery = true)
	List<AssetEntity> findByTrackerId(Long trackerId);
}
