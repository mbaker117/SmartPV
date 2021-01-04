/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.psut.smartpv.data.WeatherData;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.WeatherException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.service.WeatherService;
import com.psut.smartpv.util.ValidationUtil;

/**
 * The Class WeatherServiceImpl.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	/** The Constant APP_ID. */
	private static final String APP_ID = "fcea00a2919b2dd0dc7cad79e99a8e1d";
	
	/** The Constant URL. */
	private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?";
	
	/** The Constant LONG_KEY. */
	private static final String LONG_KEY = "lon";
	
	/** The Constant LAT_KEY. */
	private static final String LAT_KEY = "lat";
	
	/** The Constant APP_ID_KEY. */
	private static final String APP_ID_KEY = "appid";
	
	/** The Constant CNT_KEY. */
	private static final String CNT_KEY = "cnt";
	
	/** The Constant UNITS_KEY. */
	private static final String UNITS_KEY = "units";
	
	/** The Constant UNITS_TYPE. */
	private static final String UNITS_TYPE = "metric";

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Gets the weather.
	 *
	 * @param longitude         the longitude
	 * @param latitude          the latitude
	 * @param numberOfTimeStamp the number of time stamp
	 * @return the weather
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public Optional<WeatherData> getWeather(double longitude, double latitude, int numberOfTimeStamp)
			throws SmartPvException {
		LOG.info("start getWeather");
		long nanoTime = System.nanoTime();
		if (!ValidationUtil.isValidLatitude(latitude)) {
			LOG.error(SmartPvExceptionType.INVALID_LATITUDE.getMsg());
			throw new SmartPvException(SmartPvExceptionType.INVALID_LATITUDE,
					SmartPvExceptionType.INVALID_LATITUDE.getMsg());
		}
		if (!ValidationUtil.isValidLatitude(longitude)) {
			LOG.error(SmartPvExceptionType.INVALID_LONGITUDE.getMsg());
			throw new SmartPvException(SmartPvExceptionType.INVALID_LONGITUDE,
					SmartPvExceptionType.INVALID_LONGITUDE.getMsg());
		}

		String url = String.format(
				URL + LONG_KEY + "=%s&" + LAT_KEY + "=%s&" + APP_ID_KEY + "=%s&" + CNT_KEY + "=%d&" + UNITS_KEY + "=%s",
				longitude, latitude, APP_ID, numberOfTimeStamp, UNITS_TYPE);
		WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
		if (weatherData.getCod() != 200) {
			String msg = SmartPvExceptionType.WEATHER_EXCEPTION.getMsg() + "with error code = " + weatherData.getCod();
			LOG.error(msg);
			throw new WeatherException(weatherData.getCod(), msg);
		}
		LOG.info("finished getWeather with latency={}", System.nanoTime() - nanoTime);
		return Optional.ofNullable(weatherData);
	}

}
