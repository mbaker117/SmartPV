/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.data.AiDayRequestData;
import com.psut.smartpv.data.WeatherData;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.mapper.WeatherToAiMapper;
import com.psut.smartpv.service.WeatherService;

/**
 * The Class WeatherController.
 */
@RestController
@RequestMapping("/weathers")
public class WeatherController {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

	/** The weather service. */
	@Autowired
	private WeatherService weatherService;

	/** The weather to ai mapper. */
	@Autowired
	private WeatherToAiMapper weatherToAiMapper;

	/**
	 * Gets the weather data.
	 *
	 * @param longitude          the longitude
	 * @param latitude           the latitude
	 * @param numberOfTimeStamps the number of time stamps
	 * @return the weather data
	 */
	@GetMapping
	public WeatherData getWeatherData(Double longitude, Double latitude, Integer numberOfTimeStamps) {
		long nanoTime = System.nanoTime();
		LOG.info("start  WeatherController getWeatherData");
		Optional<WeatherData> weather = null;
		try {
			weather = weatherService.getWeather(longitude, latitude, numberOfTimeStamps);
		} catch (SmartPvException e) {
			LOG.info(e.getMessage());
			e.printStackTrace();
			return null;
		}

		if (!weather.isPresent()) {
			LOG.info("no weather data ");
			return null;
		}

		LOG.info("finished WeatherController getWeatherData with latency= {}", System.nanoTime() - nanoTime);
		return weather.get();

	}

	/**
	 * Gets the date mapped next day.
	 *
	 * @param longitude the longitude
	 * @param latitude  the latitude
	 * @return the date mapped next day
	 * @throws SmartPvException the smart pv exception
	 */
	@GetMapping("/mapped/one")
	public AiDayRequestData getDateMappedNextDay(Double longitude, Double latitude) throws SmartPvException {

		return weatherToAiMapper.getWeatherToAiDataNextDay(weatherService.getWeather(longitude, latitude, 16).get());

	}

	/**
	 * Gets the date mapped next four days.
	 *
	 * @param longitude the longitude
	 * @param latitude  the latitude
	 * @return the date mapped next four days
	 * @throws SmartPvException the smart pv exception
	 */
	@GetMapping("/mapped/four")
	public List<AiDayRequestData> getDateMappedNextFourDays(Double longitude, Double latitude) throws SmartPvException {

		return weatherToAiMapper.getWeatherToAiDataNextFourDays(weatherService.getWeather(longitude, latitude, 40).get());

	}
	
	/**
	 * Gets the date mappedfor day four.
	 *
	 * @param longitude the longitude
	 * @param latitude  the latitude
	 * @return the date mappedfor day four
	 * @throws SmartPvException the smart pv exception
	 */
	@GetMapping("/mapped/dayfour")
	public AiDayRequestData getDateMappedforDayFour(Double longitude, Double latitude) throws SmartPvException {

		return weatherToAiMapper.getWeatherToAiDataDayFour(weatherService.getWeather(longitude, latitude, 40).get());

	}
}
