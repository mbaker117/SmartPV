/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.data.AiData;
import com.psut.smartpv.data.AiDayRequestData;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.facade.ExpectedReadingFacade;
import com.psut.smartpv.mapper.WeatherToAiMapper;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.ExpectedReading;
import com.psut.smartpv.service.AiService;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.ExpectedReadingService;
import com.psut.smartpv.service.WeatherService;

/**
 * The Class ExpectedReadingFacadeImpl.
 */
@Component
public class ExpectedReadingFacadeImpl implements ExpectedReadingFacade {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ExpectedReadingFacadeImpl.class);

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/** The weather service. */
	@Autowired
	private WeatherService weatherService;

	/** The expected reading service. */
	@Autowired
	private ExpectedReadingService expectedReadingService;

	/** The weather to ai mapper. */
	@Autowired
	private WeatherToAiMapper weatherToAiMapper;

	/** The ai service. */
	@Autowired
	private AiService aiService;

	/**
	 * Adds the expected reading to all devices.
	 *
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void addExpectedReadingToAllDevices() throws SmartPvException {
		LOG.debug("start ExpectedReadingFacadeImpl addExpectedReadingToAllDevices");
		long nanoTime = System.nanoTime();

		List<Device> allDevices = deviceService.getAllDevices();
		if (allDevices == null) {
			LOG.info("no devices");
			return;
		}
		for (Device device : allDevices) {
			// if
			// (!expectedReadingService.getExpectedReadingByDeviceAndDate(device.getId(),new
			// Date()).isPresent()) {
			addFiveDays(device);
			// continue;
			// }
			// addDayFour(device);
		}
		LOG.info("finished ExpectedReadingFacadeImpl addExpectedReadingToAllDevices with latency = {}",
				(System.nanoTime() - nanoTime));

	}

	/**
	 * Adds the five days.
	 *
	 * @param device the device
	 * @throws SmartPvException the smart pv exception
	 */
	private void addFiveDays(Device device) throws SmartPvException {
		LOG.debug("start ExpectedReadingFacadeImpl addFourDays");
		long nanoTime = System.nanoTime();

		List<AiDayRequestData> weatherToAiDataNextFourDays = weatherToAiMapper.getWeatherToAiDataNextFourDays(
				(weatherService.getWeather(device.getLongitude(), device.getLatitude(), 40).get()));
		for (AiDayRequestData day : weatherToAiDataNextFourDays) {
			Optional<ExpectedReading> expectedReading = expectedReadingService
					.getExpectedReadingByDeviceAndDate(device.getId(), day.getDate());
			try {
				AiData power = aiService.getPower(day.getData()).get();

				if (!expectedReading.isPresent())
					expectedReadingService.addExpectedReadingByDeviceId(device.getId(), power.getEnergy(),
							day.getDate());
				else
					expectedReadingService.updateExpectedReadingByDeviceId(expectedReading.get().getId(),
							device.getId(), power.getEnergy());
			} catch (SmartPvException e) {
				if (!expectedReading.isPresent())
					expectedReadingService.addExpectedReadingByDeviceId(device.getId(), 0, day.getDate());
				LOG.error(e.getMessage());
				if (e.getType() != SmartPvExceptionType.EXPECTED_READING_ALREADY_EXIST)
					throw e;
			}
		}
		LOG.info("finished ExpectedReadingFacadeImpl addFourDays with latency = {}", (System.nanoTime() - nanoTime));

	}

	/**
	 * Adds the day four.
	 *
	 * @param device the device
	 * @throws SmartPvException the smart pv exception
	 */
	private void addDayFour(Device device) throws SmartPvException {
		LOG.debug("start ExpectedReadingFacadeImpl addDayFour");
		long nanoTime = System.nanoTime();

		AiDayRequestData day = weatherToAiMapper.getWeatherToAiDataDayFour(
				(weatherService.getWeather(device.getLongitude(), device.getLatitude(), 40).get()));
		AiData power = aiService.getPower(day.getData()).get();
		try {
			expectedReadingService.addExpectedReadingByDeviceId(device.getId(), power.getEnergy(), day.getDate());
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			if (e.getType() != SmartPvExceptionType.EXPECTED_READING_ALREADY_EXIST)
				throw e;
		}
		LOG.info("finished ExpectedReadingFacadeImpl addDayFour with latency = {}", (System.nanoTime() - nanoTime));
	}

}
