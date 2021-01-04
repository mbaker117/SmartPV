/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.service.DeviceService;

/**
 * The Class DeviceController.
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(DeviceController.class);

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/**
	 * Adds the device.
	 *
	 * @param imei                the imei
	 * @param longitude           the longitude
	 * @param latitude            the latitude
	 * @param ratedOut            the rated out
	 * @param ratedCapacity       the rated capacity
	 * @param tiltAngleHorizontal the tilt angle horizontal
	 * @param tiltAngleVertical   the tilt angle vertical
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> addDevice(@RequestParam(name = "imei") String imei,
			@RequestParam(name = "longitude") double longitude, @RequestParam(name = "latitude") double latitude,
			@RequestParam(name = "ratedOut") double ratedOut,
			@RequestParam(name = "ratedCapacity") double ratedCapacity,
			@RequestParam(name = "tiltAngleHorizontal") double tiltAngleHorizontal,
			@RequestParam(name = "tiltAngleVertical") double tiltAngleVertical) {

		LOG.info("start DeviceController addDevice");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			deviceService.addDevice(imei, longitude, latitude, ratedOut, ratedCapacity, tiltAngleHorizontal,
					tiltAngleVertical);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		LOG.info("finished DeviceController addDevice with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Update device.
	 *
	 * @param id                  the id
	 * @param imei                the imei
	 * @param longitude           the longitude
	 * @param latitude            the latitude
	 * @param ratedOut            the rated out
	 * @param ratedCapacity       the rated capacity
	 * @param tiltAngleHorizontal the tilt angle horizontal
	 * @param tiltAngleVertical   the tilt angle vertical
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<String> updateDevice(@RequestParam(name = "id") long id,
			@RequestParam(name = "imei") String imei, @RequestParam(name = "longitude") double longitude,
			@RequestParam(name = "latitude") double latitude, @RequestParam(name = "ratedOut") double ratedOut,
			@RequestParam(name = "ratedCapacity") double ratedCapacity,
			@RequestParam(name = "tiltAngleHorizontal") double tiltAngleHorizontal,
			@RequestParam(name = "tiltAngleVertical") double tiltAngleVertical) {

		LOG.info("start DeviceController updateDevice");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			deviceService.updateDevice(id, imei, longitude, latitude, ratedOut, ratedCapacity, tiltAngleHorizontal,
					tiltAngleVertical);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			if (e.getType() == SmartPvExceptionType.DEVICE_NOT_FOUND)
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			else
				responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		LOG.info("finished DeviceController updateDevice with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Gets the all devices.
	 *
	 * @return the all devices
	 */
	@GetMapping
	public List<Device> getAllDevices() {
		LOG.info("start DeviceController getAllDevices");
		long nanoTime = System.nanoTime();
		List<Device> allDevices = deviceService.getAllDevices();
		LOG.info("finished DeviceController getAllDevices with latency={}", System.nanoTime() - nanoTime);
		return allDevices;
	}

	/**
	 * Gets the all activated devices.
	 *
	 * @return the all activated devices
	 */
	@GetMapping("/activated")
	public List<Device> getAllActivatedDevices() {
		LOG.info("start DeviceController getAllDevices");
		long nanoTime = System.nanoTime();
		List<Device> allDevices = deviceService.getAllActivatedDevices();
		LOG.info("finished DeviceController getAllDevices with latency={}", System.nanoTime() - nanoTime);
		return allDevices;
	}

	/**
	 * Gets the device by id.
	 *
	 * @param id the id
	 * @return the device by id
	 */
	@GetMapping("/{id}")
	public Device getDeviceById(@PathVariable(name = "id") long id) {
		LOG.info("start DeviceController getDeviceById");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceService.getDeviceById(id);
		LOG.info("finished DeviceController getDeviceById with latency={}", System.nanoTime() - nanoTime);
		return deviceById.get();
	}

	/**
	 * Gets the device by imei.
	 *
	 * @param imei the imei
	 * @return the device by imei
	 */
	@GetMapping("/imei/{imei}")
	public Device getDeviceByImei(@PathVariable(name = "imei") String imei) {
		LOG.info("start DeviceController getDeviceByImei");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceService.getDeviceByImei(imei);
		LOG.info("finished DeviceController getDeviceByImei with latency={}", System.nanoTime() - nanoTime);
		return deviceById.get();
	}

	/**
	 * Delete device by id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDeviceById(@PathVariable(name = "id") long id) {
		LOG.info("start DeviceController deleteDeviceById");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			deviceService.deleteDevice(id);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		LOG.info("finished DeviceController deleteDeviceById with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Activate device by id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}/activate")
	public ResponseEntity<String> activateDeviceById(@PathVariable(name = "id") long id) {
		LOG.info("start DeviceController activateDeviceById");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			deviceService.activateDeviceById(id);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		LOG.info("finished DeviceController activateDeviceById with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}
}
