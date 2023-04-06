package com.smartlogistics.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Incidents {

	private Integer totalCount;
	private List<NotificationFieldsDTO> incidentsList;
	
}
