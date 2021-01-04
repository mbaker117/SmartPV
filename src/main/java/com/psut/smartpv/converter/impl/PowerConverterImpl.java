/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.converter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.PowerConverter;
import com.psut.smartpv.converter.TimeConverter;
import com.psut.smartpv.model.RealTimeReading;

/**
 * The Class PowerConverterImpl.
 */
@Component
public class PowerConverterImpl implements PowerConverter {

	/** The time converter. */
	@Autowired
	private TimeConverter timeConverter;

	/**
	 * Convert power to energy.
	 *
	 * @param readings the readings
	 * @return the double
	 */
	@Override
	public double convertPowerToEnergy(List<RealTimeReading> readings) {
		double energy = 0;
		double prevTime = 0;
		for (RealTimeReading reading : readings) {
			
			double dateToDouble = timeConverter.convertDateToDouble(reading.getTime());
			energy += reading.getOutput() * (dateToDouble - prevTime);
			prevTime = dateToDouble;
		}
		return energy;
	}

}
