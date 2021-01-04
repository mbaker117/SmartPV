/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.converter.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.WeatherConverter;

/**
 * The Class WeatherConverterImpl.
 */
@Component
public class WeatherConverterImpl implements WeatherConverter {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(WeatherConverterImpl.class);

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	/** The Constant TIME_ZONE. */
	private static final String TIME_ZONE = "Jordan/Amman";

	/** The Constant DATE_SPLITER. */
	private static final String DATE_SPLITER = " ";

	/** The Constant TIME_SPLITER. */
	private static final String TIME_SPLITER = ":";

	/** The Constant LONG_MULT. */
	private static final int LONG_MULT = 1000;

	/**
	 * Long date to hour.
	 *
	 * @param date the date
	 * @return the int
	 */
	@Override
	public int longDateToHour(long date) {
		LOG.info("start longDateToHour");
		long nanoTime = System.nanoTime();
		Date d = new Date(date * LONG_MULT);
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
		String[] split = format.format(d).split(DATE_SPLITER);
		String[] split2 = split[1].split(TIME_SPLITER);
		LOG.info("finished longDateToHour with latency = {}", (System.nanoTime() - nanoTime));
		return Integer.valueOf(split2[0]);
	}
}
