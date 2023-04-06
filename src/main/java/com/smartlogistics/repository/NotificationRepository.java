package com.smartlogistics.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smartlogistics.entity.NotificationEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long>{
		
		static final String QUERY_TO_GET_NOTIFICATIONS_BY_WAREHOUSEID =" select * from notification where warehouse_id =:warehouseId and asset_id=:assetId and asset_type=:assetType and notification_type=:notificationType ";
	
		@Query(value = QUERY_TO_GET_NOTIFICATIONS_BY_WAREHOUSEID,nativeQuery = true)
		List<NotificationEntity> getNotifications(Long warehouseId, Long assetId, String assetType, String notificationType);
	
}
