package com.smartlogistics.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Events {
	
	private Integer totalCount;
	private List<NotificationFieldsDTO> eventsList;
}
