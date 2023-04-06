package com.smartlogistics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Access_Point_Tag")
public class AccessPointTagEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="access_Point_Tag_Id")
	private Long accessPointTagId;
	
	
	@Column(name="tracker_Id")
	private Long tracker_Id;
	
	
	/*
	 * @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE
	 * })//@JoinColumn(name="access_point_id") private AccessPointEntity
	 * accessPointEntity;
	 */
	 

}
