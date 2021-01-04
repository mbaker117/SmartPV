/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dto;

import java.util.List;

/**
 * The Class DeviceReadingsDto.
 */
public class DeviceReadingsDto {
	
	/** The readings. */
	private List<DeviceReadingDto> readings;

	/**
	 * Instantiates a new device readings dto.
	 *
	 * @param readings the readings.
	 */
	public DeviceReadingsDto(List<DeviceReadingDto> readings) {
		super();
		this.readings = readings;
	}

	/**
	 * Gets the readings.
	 *
	 * @return the readings
	 */
	public List<DeviceReadingDto> getReadings() {
		return readings;
	}

	/**
	 * Sets the readings.
	 *
	 * @param readings the new readings
	 */
	public void setReadings(List<DeviceReadingDto> readings) {
		this.readings = readings;
	}
	

}
