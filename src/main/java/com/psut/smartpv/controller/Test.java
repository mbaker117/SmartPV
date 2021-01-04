/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.dto.DeviceReadingDto;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.AcctualEnergyFacade;
import com.psut.smartpv.facade.DeviceReadingFacade;
import com.psut.smartpv.facade.ExpectedReadingFacade;

/**
 * The Class Test.
 */
@RestController
@RequestMapping("/tests")
public class Test {

	/** The facade. */
	@Autowired
	private DeviceReadingFacade facade;

	/** The acctual energy facade. */
	@Autowired
	private AcctualEnergyFacade acctualEnergyFacade;

	/** The expected reading facade. */
	@Autowired
	private ExpectedReadingFacade expectedReadingFacade;

	/**
	 * Gets the data.
	 *
	 * @param id the id
	 * @return the data
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@GetMapping("/{id}")
	public DeviceReadingDto getData(@PathVariable(name = "id") long id) throws SmartPvException, ParseException {
		return facade.getDeviceReadingByCurrentDate(id);
	}

	/**
	 * Update accutal.
	 *
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@GetMapping("/")
	public void updateAccutal() throws SmartPvException, ParseException {
		acctualEnergyFacade.calculateAcctualEnergy();
	}

	/**
	 * Gets the expected.
	 *
	 * @return the expected
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@GetMapping("/aa")
	public void getExpected() throws SmartPvException, ParseException {
		expectedReadingFacade.addExpectedReadingToAllDevices();
	}

}
