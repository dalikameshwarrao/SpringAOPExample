package com.smartlogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartlogistics.entity.AssetEntity;

public interface AssetRepository  extends JpaRepository<AssetEntity, Long>{

}
