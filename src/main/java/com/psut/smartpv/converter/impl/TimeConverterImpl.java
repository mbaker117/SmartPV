/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.converter.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.TimeConverter;

/**
 * The Class TimeConverterImpl.
 */
@Component
public class TimeConverterImpl implements TimeConverter {
	
	/**
	 * Convert date to double.
	 *
	 * @param date the date
	 * @return the double
	 */
	@Override
	public double convertDateToDouble(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		double min = calendar.get(Calendar.MINUTE) / 60.0;

		return (double) hours + min;
	}

}
