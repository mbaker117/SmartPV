/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.model.Device;

/**
 * The Interface DeviceService.
 */
@Service
public interface DeviceService {

	/**
	 * Adds the device.
	 *
	 * @param imei                the imei
	 * @param longitude           the longitude
	 * @param latitude            the latitude
	 * @param ratedOut            the rated out
	 * @param ratedCapacity       the rated capacity
	 * @param tiltAngleHorizontal the tilt angle horizontal
	 * @param tiltAngleVertical   the tilt angle vertical
	 * @throws SmartPvException the smart pv exception
	 */
	public void addDevice(String imei, double longitude, double latitude, double ratedOut, double ratedCapacity,
			double tiltAngleHorizontal, double tiltAngleVertical

	) throws SmartPvException;

	/**
	 * Update device.
	 *
	 * @param id                  the id
	 * @param imei                the imei
	 * @param longitude           the longitude
	 * @param latitude            the latitude
	 * @param ratedOut            the rated out
	 * @param ratedCapacity       the rated capacity
	 * @param tiltAngleHorizontal the tilt angle horizontal
	 * @param tiltAngleVertical   the tilt angle vertical
	 * @throws SmartPvException the smart pv exception
	 */
	public void updateDevice(long id, String imei, double longitude, double latitude, double ratedOut,
			double ratedCapacity, double tiltAngleHorizontal, double tiltAngleVertical

	) throws SmartPvException;

	/**
	 * Gets the device by id.
	 *
	 * @param id the id
	 * @return the device by id
	 */
	public Optional<Device> getDeviceById(long id);

	/**
	 * Gets the all devices.
	 *
	 * @return the all devices
	 */
	public List<Device> getAllDevices();

	/**
	 * Gets the all activated devices.
	 *
	 * @return the all activated devices
	 */
	public List<Device> getAllActivatedDevices();

	/**
	 * Delete device.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	public void deleteDevice(long id) throws SmartPvException;

	/**
	 * Gets the device by imei.
	 *
	 * @param imei the imei
	 * @return the device by imei
	 */
	public Optional<Device> getDeviceByImei(String imei);

	/**
	 * Activate device by id.
	 *
	 * @param deviceId the device id
	 * @throws SmartPvException the smart pv exception
	 */
	public void activateDeviceById(long deviceId) throws SmartPvException;

	/**
	 * Activate device by imei.
	 *
	 * @param imei the imei
	 * @throws SmartPvException the smart pv exception
	 */
	public void activateDeviceByImei(String imei) throws SmartPvException;

	/**
	 * Sets the working.
	 *
	 * @param id      the id
	 * @param working the working
	 * @throws SmartPvException the smart pv exception
	 */
	public void setWorking(long id, boolean working) throws SmartPvException;
	
	/**
	 * De activate device.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	public void deActivateDevice(long id) throws SmartPvException;

}
