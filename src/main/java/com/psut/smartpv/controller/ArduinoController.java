/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

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
		arduinoFacade.addData(imei, data);
	}

}
