/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.converter;

import java.util.List;

import com.psut.smartpv.model.RealTimeReading;

/**
 * The Interface PowerConverter.
 */
public interface PowerConverter {
	
	/**
	 * Convert power to energy.
	 *
	 * @param readings the readings
	 * @return the double
	 */
	public double convertPowerToEnergy(List<RealTimeReading> readings);

}
