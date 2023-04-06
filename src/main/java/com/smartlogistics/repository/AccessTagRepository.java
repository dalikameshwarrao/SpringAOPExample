package com.smartlogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartlogistics.entity.AccessPointTagEntity;



@Repository
public interface AccessTagRepository extends JpaRepository<AccessPointTagEntity, Long>{

}
