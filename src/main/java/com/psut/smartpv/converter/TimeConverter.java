/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.converter;

import java.util.Date;

/**
 * The Interface TimeConverter.
 */
public interface TimeConverter {
	
	/**
	 * Convert date to double.
	 *
	 * @param date the date
	 * @return the double
	 */
	public double convertDateToDouble(Date date);

}
