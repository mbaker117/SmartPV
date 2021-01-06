/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.model.ExpectedReading;

/**
 * The Interface ExpectedReadingService.
 */
public interface ExpectedReadingService {

	/**
	 * Adds the expected reading by device id.
	 *
	 * @param deviceId       the device id
	 * @param expectedEnergy the expected energy
	 * @param date           the date
	 * @throws SmartPvException the smart pv exception
	 */
	public void addExpectedReadingByDeviceId(long deviceId, double expectedEnergy,Date date) throws SmartPvException;

	/**
	 * Update expected reading by device id.
	 *
	 * @param id             the id
	 * @param deviceId       the device id
	 * @param expectedEnergy the expected energy
	 * @throws SmartPvException the smart pv exception
	 */
	public void updateExpectedReadingByDeviceId(long id, long deviceId, double expectedEnergy) throws SmartPvException;

	/**
	 * Gets the expected reading by id.
	 *
	 * @param id the id
	 * @return the expected reading by id
	 */
	public Optional<ExpectedReading> getExpectedReadingById(long id);

	/**
	 * Gets the expected reading by device and date.
	 *
	 * @param deviceId the device id
	 * @param date     the date
	 * @return the expected reading by device and date
	 * @throws SmartPvException the smart pv exception
	 */
	public Optional<ExpectedReading> getExpectedReadingByDeviceAndDate(long deviceId, Date date)
			throws SmartPvException;

	/**
	 * Gets the expected reading by device.
	 *
	 * @param deviceId the device id
	 * @return the expected reading by device
	 * @throws SmartPvException the smart pv exception
	 */
	public List<ExpectedReading> getExpectedReadingByDevice(long deviceId) throws SmartPvException;

	/**
	 * Gets the all expected readings.
	 *
	 * @return the all expected readings
	 */
	public List<ExpectedReading> getAllExpectedReadings();

	/**
	 * Delete expected reading.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	public void deleteExpectedReading(long id) throws SmartPvException;
	
	/**
	 * Adds the acctual reading.
	 *
	 * @param id             the id
	 * @param acctualReading the acctual reading
	 * @throws SmartPvException the smart pv exception
	 */
	public void addAcctualReading(long id, double acctualReading) throws SmartPvException;	

}
