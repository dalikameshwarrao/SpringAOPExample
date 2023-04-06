package com.smartlogistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartlogistics.entity.WarehouseEntity;


public interface WarehouseRepository extends JpaRepository<WarehouseEntity, String> {

	List<WarehouseEntity> findByWarehouseId(String warehouseId);

}
