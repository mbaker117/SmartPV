/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.model.RealTimeReading;

/**
 * The Interface RealTimeReadingService.
 */
public interface RealTimeReadingService {

	/**
	 * Adds the real time reading by device id.
	 *
	 * @param output     the output
	 * @param tempreture the tempreture
	 * @param humidity   the humidity
	 * @param deviceId   the device id
	 * @throws SmartPvException the smart pv exception
	 */
	public void addRealTimeReadingByDeviceId(double output, double tempreture, double humidity, long deviceId)
			throws SmartPvException;

	/**
	 * Update real time reading by device id.
	 *
	 * @param id         the id
	 * @param output     the output
	 * @param tempreture the tempreture
	 * @param humidity   the humidity
	 * @param deviceId   the device id
	 * @throws SmartPvException the smart pv exception
	 */
	public void updateRealTimeReadingByDeviceId(long id, double output, double tempreture, double humidity, long deviceId)
			throws SmartPvException;

	/**
	 * Gets the real time reading by id.
	 *
	 * @param id the id
	 * @return the real time reading by id
	 */
	public Optional<RealTimeReading> getRealTimeReadingById(long id);

	/**
	 * Gets the real time reading by device and date.
	 *
	 * @param deviceId the device id
	 * @param date     the date
	 * @return the real time reading by device and date
	 * @throws SmartPvException the smart pv exception
	 */
	public List<RealTimeReading> getRealTimeReadingByDeviceAndDate(long deviceId, Date date) throws SmartPvException;

	/**
	 * Gets the real time reading by device.
	 *
	 * @param deviceId the device id
	 * @return the real time reading by device
	 * @throws SmartPvException the smart pv exception
	 */
	public List<RealTimeReading> getRealTimeReadingByDevice(long deviceId) throws SmartPvException;

	/**
	 * Gets the all real time readings.
	 *
	 * @return the all real time readings
	 */
	public List<RealTimeReading> getAllRealTimeReadings();

	/**
	 * Delete real time reading.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	public void deleteRealTimeReading(long id) throws SmartPvException;

}
