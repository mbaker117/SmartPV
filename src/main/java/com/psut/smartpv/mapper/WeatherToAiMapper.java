/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.mapper;

import java.util.List;

import com.psut.smartpv.data.AiDayRequestData;
import com.psut.smartpv.data.WeatherData;

/**
 * The Interface WeatherToAiMapper.
 */
public interface WeatherToAiMapper {
	
	/**
	 * Gets the weather to ai data next four days.
	 *
	 * @param data the data
	 * @return the weather to ai data next four days
	 */
	public List<AiDayRequestData> getWeatherToAiDataNextFourDays(WeatherData data);
	
	/**
	 * Gets the weather to ai data next day.
	 *
	 * @param data the data
	 * @return the weather to ai data next day
	 */
	public AiDayRequestData getWeatherToAiDataNextDay(WeatherData data);
	
	/**
	 * Gets the weather to ai data day four.
	 *
	 * @param data the data
	 * @return the weather to ai data day four
	 */
	public AiDayRequestData getWeatherToAiDataDayFour(WeatherData data);

}
