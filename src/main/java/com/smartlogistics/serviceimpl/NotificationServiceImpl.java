package com.smartlogistics.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlogistics.dto.Alerts;
import com.smartlogistics.dto.Events;
import com.smartlogistics.dto.Incidents;
import com.smartlogistics.dto.NotificationDTO;
import com.smartlogistics.dto.NotificationFieldsDTO;
import com.smartlogistics.dto.NotificationResponseDTO;
import com.smartlogistics.entity.NotificationEntity;
import com.smartlogistics.repository.NotificationRepository;
import com.smartlogistics.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
		public static final String EVENT = "Events";
		public static final String INCIDENT = "Incident";
		public static final String ALERT = "Alerts";
	

	
	@Override
	public NotificationResponseDTO getAllnotificationsByType(Long warehouseId, Long assetId, String type) {
		NotificationResponseDTO notificationResponseDTO = new NotificationResponseDTO();
		Events events = new Events();
		Incidents incidents = new Incidents();
		Alerts alerts = new Alerts(); 
		List<NotificationEntity> eventNotificationEntityList = notificationRepository.getNotifications(warehouseId,assetId,type,EVENT);
		List<NotificationEntity> alertNotificationEntityList = notificationRepository.getNotifications(warehouseId,assetId,type,ALERT);
		List<NotificationEntity> incidentNotificationEntityList = notificationRepository.getNotifications(warehouseId,assetId,type,INCIDENT);
		String warehouseLoc= new String() ;
		if(!eventNotificationEntityList.isEmpty())
			warehouseLoc = eventNotificationEntityList.get(0).getWarehouseLoc();
		
			if(!alertNotificationEntityList.isEmpty())
				warehouseLoc = alertNotificationEntityList.get(0).getWarehouseLoc();
				
				if(!incidentNotificationEntityList.isEmpty())
					warehouseLoc = alertNotificationEntityList.get(0).getWarehouseLoc();
		// events list and count
		if(!eventNotificationEntityList.isEmpty()) {
			List<NotificationFieldsDTO> notificationFieldsDTOList = new ArrayList<>();
			for (NotificationEntity notificationEntity : eventNotificationEntityList) {
				NotificationFieldsDTO notificationFieldsDTO = new NotificationFieldsDTO();
				notificationFieldsDTO.setEquipLocation(notificationEntity.getEquipmentLocation());
				notificationFieldsDTO.setEquipType(notificationEntity.getEquipmentType());
				notificationFieldsDTO.setEquipUtilization(notificationEntity.getEquipmentUtilization());
				notificationFieldsDTO.setEventTime(notificationEntity.getEventDateAndTime());
				notificationFieldsDTO.setLocation(notificationEntity.getWarehouseLoc());
				notificationFieldsDTO.setRackerDetail(notificationEntity.getRackerDetails());
				notificationFieldsDTO.setReason(notificationEntity.getReason());
				notificationFieldsDTO.setTemperature(notificationEntity.getTemperature());
				notificationFieldsDTO.setTrackerBattery(notificationEntity.getTrackerBattery());
				notificationFieldsDTO.setTrackerId(notificationEntity.getTrackerId());
				notificationFieldsDTO.setTrackerStatus(notificationEntity.getTrackerStatus());
				notificationFieldsDTOList.add(notificationFieldsDTO);
			}
			events.setEventsList(notificationFieldsDTOList);
			events.setTotalCount(eventNotificationEntityList.size());
		}
		
		
		if(!alertNotificationEntityList.isEmpty()) {
			List<NotificationFieldsDTO> notificationFieldsDTOList = new ArrayList<>();
			for (NotificationEntity notificationEntity : alertNotificationEntityList) {
				NotificationFieldsDTO notificationFieldsDTO = new NotificationFieldsDTO();
				notificationFieldsDTO.setEquipLocation(notificationEntity.getEquipmentLocation());
				notificationFieldsDTO.setEquipType(notificationEntity.getEquipmentType());
				notificationFieldsDTO.setEquipUtilization(notificationEntity.getEquipmentUtilization());
				notificationFieldsDTO.setEventTime(notificationEntity.getEventDateAndTime());
				notificationFieldsDTO.setLocation(notificationEntity.getWarehouseLoc());
				notificationFieldsDTO.setRackerDetail(notificationEntity.getRackerDetails());
				notificationFieldsDTO.setReason(notificationEntity.getReason());
				notificationFieldsDTO.setTemperature(notificationEntity.getTemperature());
				notificationFieldsDTO.setTrackerBattery(notificationEntity.getTrackerBattery());
				notificationFieldsDTO.setTrackerId(notificationEntity.getTrackerId());
				notificationFieldsDTO.setTrackerStatus(notificationEntity.getTrackerStatus());
				notificationFieldsDTOList.add(notificationFieldsDTO);
			}
			
			alerts.setAlertsList(notificationFieldsDTOList);
			alerts.setTotalCount(alertNotificationEntityList.size());
			
		}
		
		
		if(!incidentNotificationEntityList.isEmpty()) {
			List<NotificationFieldsDTO> notificationFieldsDTOList = new ArrayList<>();
			for (NotificationEntity notificationEntity : incidentNotificationEntityList) {
				NotificationFieldsDTO notificationFieldsDTO = new NotificationFieldsDTO();
				notificationFieldsDTO.setEquipLocation(notificationEntity.getEquipmentLocation());
				notificationFieldsDTO.setEquipType(notificationEntity.getEquipmentType());
				notificationFieldsDTO.setEquipUtilization(notificationEntity.getEquipmentUtilization());
				notificationFieldsDTO.setEventTime(notificationEntity.getEventDateAndTime());
				notificationFieldsDTO.setLocation(notificationEntity.getWarehouseLoc());
				notificationFieldsDTO.setRackerDetail(notificationEntity.getRackerDetails());
				notificationFieldsDTO.setReason(notificationEntity.getReason());
				notificationFieldsDTO.setTemperature(notificationEntity.getTemperature());
				notificationFieldsDTO.setTrackerBattery(notificationEntity.getTrackerBattery());
				notificationFieldsDTO.setTrackerId(notificationEntity.getTrackerId());
				notificationFieldsDTO.setTrackerStatus(notificationEntity.getTrackerStatus());
				notificationFieldsDTOList.add(notificationFieldsDTO);
			}
			incidents.setIncidentsList(notificationFieldsDTOList);
			incidents.setTotalCount(incidentNotificationEntityList.size());
		}
		if(type.equalsIgnoreCase("Goods")) {
			notificationResponseDTO.setBoxId(assetId.toString());
		}else {
			notificationResponseDTO.setEquipmentId(assetId.toString());
		}
		notificationResponseDTO.setWarehouseId(warehouseId.toString());
		notificationResponseDTO.setWarehouseLoc(warehouseLoc);
		NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO.setEvents(events);
		notificationDTO.setAlerts(alerts);
		notificationDTO.setIncidents(incidents);
		notificationResponseDTO.setNotificationDTO(notificationDTO);
		return notificationResponseDTO;
	}

}
