package com.smartlogistics.entity;





import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "Warehouse")
@Data
public class WarehouseEntity implements Serializable {
	
	private static final long serialVersionUID = 2316363918813058983L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "warehouse_id")
	private String warehouseId;
	
	@Column(name = "warehouse_name")
	private String warehouseName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "goods_count")
	private Integer goodsCount;
	
	@Column(name = "equipment_count")
	private Integer equipmentCount;
	
	@Column(name = "access_point_count")
	private Integer accessPointCount;
	
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
}
