/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.dto.DeviceReadingDto;
import com.psut.smartpv.dto.DeviceReadingsDto;
import com.psut.smartpv.dto.HistoryChartDto;
import com.psut.smartpv.dto.HistoryNumbersListDto;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.DeviceReadingFacade;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.User;
import com.psut.smartpv.service.UserService;

/**
 * The Class MobileController.
 */
@RestController
@RequestMapping("/mobiles")
public class MobileController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The device reading facade. */
	@Autowired
	private DeviceReadingFacade deviceReadingFacade;

	/**
	 * Gets the devices dto by email.
	 *
	 * @param email the email
	 * @return the devices dto by email
	 */
	@GetMapping("/{email}")
	public DeviceReadingsDto getDevicesDtoByEmail(@PathVariable(name = "email") String email) {
		List<DeviceReadingDto> readings = new LinkedList<DeviceReadingDto>();
		Optional<User> userByEmail = userService.getUserByEmail(email);
		if (!userByEmail.isPresent())
			return new DeviceReadingsDto(readings);
		User user = userByEmail.get();
		List<Device> devices = user.getDevices().stream().sorted().collect(Collectors.toList());
		
		for (Device device : devices) {
			try {
				readings.add(deviceReadingFacade.getDeviceReadingByCurrentDate(device.getId()));
			} catch (SmartPvException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return new DeviceReadingsDto(readings);
	}
	
	
	/**
	 * Gets the history numbers by imei.
	 *
	 * @param imei the imei
	 * @return the history numbers by imei
	 */
	@GetMapping("/history/numbers/{imei}")
	public  HistoryNumbersListDto getHistoryNumbersByImei(@PathVariable(name = "imei") String imei) {
		try {
			return  new HistoryNumbersListDto(deviceReadingFacade.getHistoryNumbers(imei));
		} catch (SmartPvException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Gets the history chart by imei.
	 *
	 * @param imei the imei
	 * @return the history chart by imei
	 */
	@GetMapping("/history/chart/{imei}")
	public  HistoryChartDto getHistoryChartByImei(@PathVariable(name = "imei") String imei) {
				
			try {
				return deviceReadingFacade.getHistoryChart(imei);
			} catch (SmartPvException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		
	}

}
