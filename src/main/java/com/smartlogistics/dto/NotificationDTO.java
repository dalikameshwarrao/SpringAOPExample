package com.smartlogistics.dto;

import java.time.LocalTime;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationDTO {

	private Events events;
    private Incidents incidents;
    private Alerts alerts;
    
}
