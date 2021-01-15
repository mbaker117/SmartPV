/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.mapper.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.WeatherConverter;
import com.psut.smartpv.data.AiDayRequestData;
import com.psut.smartpv.data.AiRequestData;
import com.psut.smartpv.data.TimeStampWeatherData;
import com.psut.smartpv.data.WeatherData;
import com.psut.smartpv.mapper.WeatherToAiMapper;

/**
 * The Class WeatherToAiMapperImpl.
 */
@Component
public class WeatherToAiMapperImpl implements WeatherToAiMapper {
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(WeatherToAiMapperImpl.class);


	/** The weather converter. */
	@Autowired
	private WeatherConverter weatherConverter;

	/**
	 * Gets the weather to ai data next four days.
	 *
	 * @param data the data
	 * @return the weather to ai data next four days
	 */
	@Override
	public List<AiDayRequestData> getWeatherToAiDataNextFourDays(WeatherData data) {
		LOG.info("start getWeatherToAiDataNextFourDays");
		long nanoTime = System.nanoTime();
		List<AiDayRequestData> daysData = new ArrayList<AiDayRequestData>();
		Date currentDay = new Date();
		List<TimeStampWeatherData> list = data.getList();
		for (int i = 0; i < 5; i++) {
			daysData.add(getOneDayData(incrementDate(currentDay, i ), list.subList(8 * i, (i + 1) * 8)));
		}
		LOG.info("finished getWeatherToAiDataNextFourDays with latency = {}", (System.nanoTime() - nanoTime));
		return daysData;
	}

	/**
	 * Gets the weather to ai data next day.
	 *
	 * @param data the data
	 * @return the weather to ai data next day
	 */
	@Override
	public AiDayRequestData getWeatherToAiDataNextDay(WeatherData data) {

		return getOneDayData(incrementDate(new Date(), 1), data.getList().subList(8, 16));
	}

	/**
	 * Increment date.
	 *
	 * @param startingDate the starting date
	 * @param numberOfDays the number of days
	 * @return the date
	 */
	private Date incrementDate(Date startingDate, int numberOfDays) {
		LOG.info("start incrementDate");
		long nanoTime = System.nanoTime();
		Calendar c = Calendar.getInstance();
		c.setTime(startingDate);
		c.add(Calendar.DAY_OF_MONTH, numberOfDays);
		LOG.info("finished incrementDate with latency = {}", (System.nanoTime() - nanoTime));
		return c.getTime();
	}

	/**
	 * Gets the one day data.
	 *
	 * @param date the date
	 * @param data the data
	 * @return the one day data
	 */
	private AiDayRequestData getOneDayData(Date date, List<TimeStampWeatherData> data) {
		LOG.info("start getOneDayData");
		long nanoTime = System.nanoTime();
		List<AiRequestData> list = new ArrayList<AiRequestData>();
		for (TimeStampWeatherData d : data.subList(2, 7)) {
			list.add(new AiRequestData(weatherConverter.longDateToHour(d.getDt()), d.getMain().getHumidity(),
					d.getMain().getTemp()));
		}
		LOG.info("finished getOneDayData with latency = {}", (System.nanoTime() - nanoTime));
		return new AiDayRequestData(date, list);
	}

	/**
	 * Gets the weather to ai data day four.
	 *
	 * @param data the data
	 * @return the weather to ai data day four
	 */
	@Override
	public AiDayRequestData getWeatherToAiDataDayFour(WeatherData data) {
		return getOneDayData(incrementDate(new Date(), 4), data.getList().subList(8*4, 40));
	}
}
