/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.User;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.UserService;

/**
 * The Class MiscController.
 */
@RestController
@RequestMapping("/misc")
public class MiscController {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(MiscController.class);

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Adds the device to user.
	 *
	 * @param imei  the imei
	 * @param email the email
	 * @return the response entity
	 */
	@PostMapping("/addDeviceToUser")
	public ResponseEntity<String> addDeviceToUser(@RequestParam("imei") String imei,
			@RequestParam("email") String email) {

		LOG.info("start ExpectedReadingController addReading ");
		long nanoTime = System.nanoTime();

		Optional<Device> deviceByImei = deviceService.getDeviceByImei(imei);
		if (!deviceByImei.isPresent()) {
			LOG.error("{} imei ={} ", SmartPvExceptionType.DEVICE_NOT_FOUND, imei);
			return ResponseEntity.status(HttpStatus.OK).body(SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Optional<User> userByEmail = userService.getUserByEmail(email);
		if (!userByEmail.isPresent()) {
			LOG.error("{} email ={} ", SmartPvExceptionType.USER_NOT_FOUND, email);
			return ResponseEntity.status(HttpStatus.OK).body(SmartPvExceptionType.USER_NOT_FOUND.getMsg());
		}

		ResponseEntity<String> responseEntity = null;
		User user = userByEmail.get();
		Set<Device> devices = user.getDevices();
		if (devices.contains(deviceByImei.get())) {
			LOG.error("{} imei ={} ", SmartPvExceptionType.DEVICE_ALREADY_EXIST, imei);
			return ResponseEntity.status(HttpStatus.OK).body(SmartPvExceptionType.DEVICE_ALREADY_EXIST.getMsg());
		}
		devices.add(deviceByImei.get());
		try {
			userService.updateUser(user);
			responseEntity = ResponseEntity.ok("OK");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}

		LOG.info("finished MiscController addDeviceToUser with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;

	}

}
