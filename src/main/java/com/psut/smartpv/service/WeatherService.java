/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service;

import java.util.Optional;

import com.psut.smartpv.data.WeatherData;
import com.psut.smartpv.exception.SmartPvException;

/**
 * The Interface WeatherService.
 */
public interface WeatherService {

	/**
	 * Gets the weather.
	 *
	 * @param longitude         the longitude
	 * @param latitude          the latitude
	 * @param numberOfTimeStamp the number of time stamp
	 * @return the weather
	 * @throws SmartPvException the smart pv exception
	 */
	public Optional<WeatherData> getWeather(double longitude,double latitude,int numberOfTimeStamp) throws SmartPvException;
}
