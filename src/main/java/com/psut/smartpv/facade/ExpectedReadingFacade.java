/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade;

import com.psut.smartpv.exception.SmartPvException;

/**
 * The Interface ExpectedReadingFacade.
 */
public interface ExpectedReadingFacade {
	
	/**
	 * Adds the expected reading to all devices.
	 *
	 * @throws SmartPvException the smart pv exception
	 */
	public void addExpectedReadingToAllDevices() throws SmartPvException;

}
