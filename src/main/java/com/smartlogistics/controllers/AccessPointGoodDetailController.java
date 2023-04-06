package com.smartlogistics.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogistics.dto.AccessPointDetailResponse;
import com.smartlogistics.dto.AccessPointGoodDetailResponseDTO;
import com.smartlogistics.dto.GoodDetailResponse;
import com.smartlogistics.dto.GoodsResponseDTO;
import com.smartlogistics.dto.RequestDTO;
import com.smartlogistics.entity.AccessPointEntity;
import com.smartlogistics.entity.AssetEntity;
import com.smartlogistics.entity.WarehouseEntity;
import com.smartlogistics.repository.WarehouseRepository;
import com.smartlogistics.service.AccessPointDetailService;
import com.smartlogistics.service.GoodDetailService;
import com.smartlogistics.util.Constants;

@RestController
@RequestMapping(path = "/smartlogistics")
public class AccessPointGoodDetailController {

	@Autowired
	private AccessPointDetailService accessPointDetailService;

	@Autowired
	private GoodDetailService goodDetailService;

	@Autowired
	private WarehouseRepository warehouseRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(AccessPointGoodDetailController.class);

	@PostMapping("/v1/getAPAndGoodsDetail")
	public AccessPointGoodDetailResponseDTO getAPAndGoodsDetail(
			@PathVariable  String warehouseId)
			throws ValidationException {
		//Constants.GOODS_TYPE;
		if (warehouseId!=null && !warehouseId.isBlank() && !warehouseId.isEmpty()) {

			AccessPointGoodDetailResponseDTO response = new AccessPointGoodDetailResponseDTO();

			LOGGER.info("Get Warehouse detail by ID from DB:: ");
			WarehouseEntity warehouseDetail = warehouseRepo.findByWarehouseId(warehouseId).get(0);
			response.setWarehouseId(String.valueOf(warehouseDetail.getWarehouseId()));
			response.setWarehouseLoc(warehouseDetail.getLocation());

			AccessPointDetailResponse apDetailResponse = new AccessPointDetailResponse();
			LOGGER.info("Get AccessPoint details list by warehouseID from DB:: ");
			List<AccessPointEntity> aPList = accessPointDetailService.getAccessPointDetailsByWarehouseId(warehouseId);
			Integer apListCount = aPList.size();
			apDetailResponse.setCount(apListCount);
			apDetailResponse.setAp_list(aPList);
			response.setAccess_point(apDetailResponse);

			GoodDetailResponse goodDetailResponse = new GoodDetailResponse();
			LOGGER.info("Get Good details list by warehouseID from DB:: ");
			List<AssetEntity> goodsList = goodDetailService.getGoodDetailByWarehouseId(warehouseId);
			Integer goodsListCount = goodsList.size();
			goodDetailResponse.setCount(goodsListCount);
			
			List<GoodsResponseDTO> goodsDataList = new ArrayList<>();
			
			if (!CollectionUtils.isEmpty(goodsList)) {
				goodsList.forEach(data -> {
					GoodsResponseDTO goodData = new GoodsResponseDTO();
					goodData.setAssetId(data.getAssetId());
					goodData.setTrackerId(data.getTrackerId());
					goodData.setTrackerStatus(data.getTrackerStatus());
					goodData.setTrackerBattery(data.getTrackerBattery());
					goodData.setTemperature(data.getTemperature());
					goodData.setNoOfUnit(data.getNoOfUnit());
					goodData.setSource(data.getSource());
					goodData.setMake(data.getMake());
					goodData.setCategory(data.getCategory());
					goodData.setDimension(data.getDimension());
					goodData.setLastUpdate(data.getLastUpdate());
					goodData.setPackagePickedUp(data.getPackagePickedUp());
					goodData.setInitialScan(data.getInitialScan());
					goodData.setStaggingAndTagging(data.getStaggingAndTagging());
					goodData.setPutaway(data.getPutaway());
					goodData.setConnected(data.getConnected());
					goodData.setStatgeOfBox(data.getStatgeOfBox());
					goodData.setGeofenceName(data.getGeofenceName());
					goodData.setGeofenceType(data.getGeofenceType());
					goodData.setGeoLatitude(data.getGeoLatitude());
					goodData.setGeoLongitude(data.getGeoLongitude());
					goodData.setRadius(data.getRadius());
					goodData.setOutsideGeofence(data.getOutsideGeofence());
					goodData.setBackToGeofence(data.getBackToGeofence());
					goodsDataList.add(goodData);
				});
			}
			goodDetailResponse.setGoods_list(goodsDataList);
			response.setGoods(goodDetailResponse);

			return response;

		} else {
			throw new ValidationException("Please provide valid warehouseId.");
		}
	}

}
