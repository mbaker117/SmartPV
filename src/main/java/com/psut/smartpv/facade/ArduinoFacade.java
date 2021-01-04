/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade;

import com.psut.smartpv.data.ArduinoDataRequest;
import com.psut.smartpv.exception.SmartPvException;

/**
 * The Interface ArduinoFacade.
 */
public interface ArduinoFacade {

	/**
	 * Adds the data.
	 *
	 * @param imei the imei
	 * @param data the data
	 * @throws SmartPvException the smart pv exception
	 */
	public void addData(String imei, ArduinoDataRequest data) throws SmartPvException;

}
