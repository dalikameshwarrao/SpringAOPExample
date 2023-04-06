package com.smartlogistics.serviceimpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlogistics.dto.ChangeGeofenceDTO;
import com.smartlogistics.entity.AssetEntity;
import com.smartlogistics.entity.NotificationEntity;
import com.smartlogistics.entity.PredictionNotificationEntity;
import com.smartlogistics.repository.AssetRepository;
import com.smartlogistics.repository.NotificationRepository;
import com.smartlogistics.repository.PredNotifyRepository;
import com.smartlogistics.service.AssetService;


@Service
public class AssetServiceImpl implements AssetService{

	
	
	@Autowired
	private AssetRepository repository;
	
	@Autowired
	private PredNotifyRepository predictionNotificationRepository;
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Override
	public AssetEntity saveAssetDetails(AssetEntity assetEntity) {
		Double assetBattery = assetEntity.getTrackerBattery();
		Double assetTemp = assetEntity.getTemperature();
		if(assetEntity.getAssetId()!=null) {
			Optional<AssetEntity> assetEntityDb = repository.findById(assetEntity.getAssetId());
			if(!assetEntityDb.isPresent()) {
				Optional<PredictionNotificationEntity> predictionNotificationEntity = predictionNotificationRepository.findById(assetEntity.getAssetId());
				if(predictionNotificationEntity.isPresent()) {
					Double predBattery = predictionNotificationEntity.get().getBatteryPercentage();
					Double predTemp = predictionNotificationEntity.get().getTemparature();
					if(Double.compare(assetBattery, predBattery)==0 && Double.compare(assetTemp, predTemp)==0) {
						NotificationEntity notificationEntity = new NotificationEntity();
						notificationEntity.setAssetId(assetEntity.getAssetId());
						notificationEntity.setNotificationId(predictionNotificationEntity.get().getNotificationId());
						notificationEntity.setNotificationType(predictionNotificationEntity.get().getStatus());
						notificationEntity.setEventDateAndTime(assetEntity.getConnected());
						notificationEntity.setTemperature(predTemp);
						notificationEntity.setTrackerBattery(predBattery);
						notificationEntity.setWarehouseId(assetEntity.getWarehouseId());
						notificationEntity.setWarehouseLoc(assetEntity.getAssetLocation());
						notificationEntity.setAssetType(assetEntity.getAssetType());
						notificationEntity.setTrackerId(assetEntity.getTrackerId());
						notificationEntity.setTrackerStatus(assetEntity.getTrackerStatus());
						notificationRepository.save(notificationEntity);
						return repository.save(assetEntity);
					}
				}
			}else {
				Optional<PredictionNotificationEntity> predictionNotificationEntity = predictionNotificationRepository.findById(assetEntity.getAssetId());
				if(predictionNotificationEntity.isPresent()) {
					Double predBattery = predictionNotificationEntity.get().getBatteryPercentage();
					Double predTemp = predictionNotificationEntity.get().getTemparature();
					if(Double.compare(assetBattery, predBattery)==0 && Double.compare(assetTemp, predTemp)==0) {
						NotificationEntity notificationEntity = new NotificationEntity();
						notificationEntity.setAssetId(assetEntity.getAssetId());
						notificationEntity.setNotificationId(predictionNotificationEntity.get().getNotificationId());
						notificationEntity.setNotificationType(predictionNotificationEntity.get().getStatus());
						notificationEntity.setEventDateAndTime(assetEntity.getConnected());
						notificationEntity.setTemperature(predTemp);
						notificationEntity.setTrackerBattery(predBattery);
						notificationEntity.setWarehouseId(assetEntity.getWarehouseId());
						notificationEntity.setWarehouseLoc(assetEntity.getAssetLocation());
						notificationEntity.setAssetType(assetEntity.getAssetType());
						notificationEntity.setTrackerId(assetEntity.getTrackerId());
						notificationEntity.setTrackerStatus(assetEntity.getTrackerStatus());
						notificationRepository.save(notificationEntity);
					}
				}

				AssetEntity assetEntityNew = assetEntityDb.get();
				assetEntityNew.setTrackerStatus(assetEntity.getTrackerStatus());
				assetEntityNew.setTrackerBattery(assetBattery);
				assetEntityNew.setTemperature(assetTemp);
				assetEntityNew.setGeoLatitude(assetEntity.getGeoLatitude());
				assetEntityNew.setGeoLongitude(assetEntity.getGeoLongitude());
				assetEntityNew.setAssetLocation(assetEntity.getAssetLocation());
				return repository.save(assetEntityNew);
			}
		}
		return null;
	}

	@Override
	public AssetEntity changeGeofenceConfig(ChangeGeofenceDTO changeGeofenceDTO) {
			Optional<AssetEntity> assetEntity = repository.findById(changeGeofenceDTO.getAssetId());
			if(assetEntity.isPresent()) {
				AssetEntity assetEntityNew = assetEntity.get();
				assetEntityNew.setGeofenceName(changeGeofenceDTO.getGeofenceName());
				assetEntityNew.setGeofenceType(changeGeofenceDTO.getGeofenceType());
				assetEntityNew.setOutsideGeofence(changeGeofenceDTO.getOutGeofence());
				assetEntityNew.setBackToGeofence(changeGeofenceDTO.getBackGeofence());
				if(changeGeofenceDTO.getGeofenceType()!=null && changeGeofenceDTO.getGeofenceType().equalsIgnoreCase("Circular")) {
					assetEntityNew.setGeoLatitude(changeGeofenceDTO.getGeoLatitude());
					assetEntityNew.setGeoLongitude(changeGeofenceDTO.getGeoLongitude());
					assetEntityNew.setRadius(changeGeofenceDTO.getGeoRadius());
				}else {
					assetEntityNew.setGeoLatitude(0.0);
					assetEntityNew.setGeoLongitude(0.0);
					assetEntityNew.setRadius(0.0);
				}
				return repository.save(assetEntityNew);
			}
		return null;
	}

}
