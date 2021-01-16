/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.data.ArduinoDataRequest;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.ArduinoFacade;

/**
 * The Class ArduinoController.
 */
@RestController
@RequestMapping("/arduino")
public class ArduinoController {

	/** The arduino facade. */
	@Autowired
	private ArduinoFacade arduinoFacade;
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(ArduinoController.class);

	/**
	 * Adds the readings.
	 *
	 * @param data the data
	 * @param imei the imei
	 * @throws SmartPvException the smart pv exception
	 */
	@PostMapping("/{imei}")
	public void addReadings(@RequestBody ArduinoDataRequest data, @PathVariable(name = "imei") String imei)
			throws SmartPvException {
		LOG.info("start addReadings imei = {}",imei);
		arduinoFacade.addData(imei, data);
		LOG.info("finished addReadings ");
	}

}
