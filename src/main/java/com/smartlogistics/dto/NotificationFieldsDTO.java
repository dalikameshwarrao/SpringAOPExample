package com.smartlogistics.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotificationFieldsDTO {
	
	 private String reason;
     private String location;
     private Date eventTime;
     private Long trackerId;
     private String trackerStatus;
     private Double trackerBattery;
     private Double temperature;
     private Double equipUtilization;
     private String rackerDetail;
     private String equipLocation;
     private String equipType;
}
