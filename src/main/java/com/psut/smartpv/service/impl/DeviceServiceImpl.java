/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psut.smartpv.dao.DeviceDao;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.User;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.util.ValidationUtil;

/**
 * The Class DeviceServiceImpl.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(DeviceServiceImpl.class);

	/** The device dao. */
	@Autowired
	private DeviceDao deviceDao;

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
	@Override
	public Device addDevice(String imei, double longitude, double latitude, double ratedOut, double ratedCapacity,
			double tiltAngleHorizontal, double tiltAngleVertical) throws SmartPvException {
		LOG.info("start addDevice");
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
		if (!ValidationUtil.isValidIMEI(imei)) {
			LOG.error(SmartPvExceptionType.INVALID_IMEI.getMsg());
			throw new SmartPvException(SmartPvExceptionType.INVALID_IMEI, SmartPvExceptionType.INVALID_IMEI.getMsg());
		}
		deviceDao.findByImei(imei);
		if (deviceDao.findByImei(imei).isPresent()) {
			LOG.error("{} with IMEI = {}", imei, SmartPvExceptionType.IMEI_ALREADY_EXIST.getMsg());
			throw new SmartPvException(SmartPvExceptionType.IMEI_ALREADY_EXIST,
					SmartPvExceptionType.IMEI_ALREADY_EXIST.getMsg());
		}
		Device device = new Device();
		device.setImei(imei);
		device.setLongitude(longitude);
		device.setLatitude(latitude);
		device.setTiltAngleHorizontal(tiltAngleHorizontal);
		device.setTiltAngleVertical(tiltAngleVertical);
		device.setRatedCapacity(ratedCapacity);
		device.setRatedOut(ratedOut);
		deviceDao.save(device);
		LOG.info("finished addDevice with latency={}", System.nanoTime() - nanoTime);
		return device;

	}

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
	@Override
	public void updateDevice(long id, String imei, double longitude, double latitude, double ratedOut,
			double ratedCapacity, double tiltAngleHorizontal, double tiltAngleVertical) throws SmartPvException {
		LOG.info("start updateDevice");
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
		/*
		 * if(!ValidationUtil.isValidIMEI(imei)) {
		 * LOG.error(SmartPvExceptionType.INVALID_IMEI.getMsg()); throw new
		 * SmartPvException(SmartPvExceptionType.INVALID_IMEI,
		 * SmartPvExceptionType.INVALID_IMEI.getMsg()); }
		 */
		Optional<Device> deviceById = deviceDao.findById(id);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), id);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Optional<Device> findByImei = deviceDao.findByImei(imei);
		if (findByImei.isPresent())
			if (deviceById.get() != findByImei.get()) {
				LOG.error("{} IMEI = {}", SmartPvExceptionType.IMEI_ALREADY_EXIST.getMsg(), imei);
				throw new SmartPvException(SmartPvExceptionType.IMEI_ALREADY_EXIST,
						SmartPvExceptionType.IMEI_ALREADY_EXIST.getMsg());
			}

		Device device = deviceById.get();
		device.setImei(imei);
		device.setLatitude(latitude);
		device.setLongitude(longitude);
		device.setRatedCapacity(ratedCapacity);
		device.setRatedOut(ratedOut);
		device.setTiltAngleHorizontal(tiltAngleHorizontal);
		device.setTiltAngleVertical(tiltAngleVertical);
		deviceDao.save(device);
		LOG.info("finished updateDevice with latency={}", System.nanoTime() - nanoTime);
	}

	/**
	 * Gets the device by id.
	 *
	 * @param id the id
	 * @return the device by id
	 */
	@Override
	public Optional<Device> getDeviceById(long id) {
		LOG.info("start getDeviceById");
		long nanoTime = System.nanoTime();
		Optional<Device> findById = deviceDao.findById(id);
		LOG.info("finished getDeviceById with latency={}", System.nanoTime() - nanoTime);
		return findById;
	}

	/**
	 * Gets the all devices.
	 *
	 * @return the all devices
	 */
	@Override
	public List<Device> getAllDevices() {
		LOG.info("start getAllDevices");
		long nanoTime = System.nanoTime();
		List<Device> findAll = deviceDao.findAll();
		LOG.info("finished getAllDevices with latency={}", System.nanoTime() - nanoTime);
		return findAll;
	}

	/**
	 * Delete device.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void deleteDevice(long id) throws SmartPvException {
		LOG.info("start deleteDevice");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = getDeviceById(id);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), id);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
	
		deviceDao.delete(deviceById.get());

		LOG.info("finished deleteDevice with latency={}", System.nanoTime() - nanoTime);
	}

	/**
	 * Gets the device by imei.
	 *
	 * @param imei the imei
	 * @return the device by imei
	 */
	@Override
	public Optional<Device> getDeviceByImei(String imei) {
		LOG.info("start getDeviceByImei");
		long nanoTime = System.nanoTime();
		Optional<Device> findByImei = deviceDao.findByImei(imei);
		LOG.info("finished getDeviceByImei with latency={}", System.nanoTime() - nanoTime);
		return findByImei;
	}

	/**
	 * Gets the all activated devices.
	 *
	 * @return the all activated devices
	 */
	@Override
	public List<Device> getAllActivatedDevices() {
		LOG.info("start getAllActivatedDevices");
		long nanoTime = System.nanoTime();
		List<Device> findAll = deviceDao.findByActivated(true);
		LOG.info("finished getAllActivatedDevices with latency={}", System.nanoTime() - nanoTime);
		return findAll;
	}

	/**
	 * Activate device by id.
	 *
	 * @param deviceId the device id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void activateDeviceById(long deviceId) throws SmartPvException {
		LOG.info("start activateDeviceById");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceDao.findById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Device device = deviceById.get();
		device.setActivated(true);
		device.setWorking(true);
		deviceDao.save(device);
		LOG.info("finished activateDeviceById with latency={}", System.nanoTime() - nanoTime);
	}

	/**
	 * Activate device by imei.
	 *
	 * @param imei the imei
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void activateDeviceByImei(String imei) throws SmartPvException {
		LOG.info("start activateDeviceByImei");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceDao.findByImei(imei);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Device device = deviceById.get();
		device.setActivated(true);
		device.setWorking(true);
		deviceDao.save(device);
		LOG.info("finished activateDeviceByImei with latency={}", System.nanoTime() - nanoTime);

	}

	/**
	 * Sets the working.
	 *
	 * @param id      the id
	 * @param working the working
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void setWorking(long id, boolean working) throws SmartPvException {
		LOG.info("start setWorking");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceDao.findById(id);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Device device = deviceById.get();

		device.setWorking(working);
		deviceDao.save(device);
		LOG.info("finished setWorking with latency={}", System.nanoTime() - nanoTime);

	}

	/**
	 * De activate device.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void deActivateDevice(long id) throws SmartPvException {
		LOG.info("start deActivateDevice");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceDao.findById(id);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Device device = deviceById.get();
		device.setActivated(false);
		deviceDao.save(device);
		LOG.info("finished deActivateDevice with latency={}", System.nanoTime() - nanoTime);

	}

	@Override
	public void addUser(long deviceId, User user) throws SmartPvException {
		LOG.info("start addUser");
		long nanoTime = System.nanoTime();
		if (Objects.isNull(user)) {
			IllegalArgumentException ex = new IllegalArgumentException("user is null");
			LOG.error(ex.getMessage());
			throw ex;
		}
		Optional<Device> deviceById = deviceDao.findById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		deviceById.get().setUser(user);
		deviceDao.save(deviceById.get());
		LOG.info("finished addUser with latency={}", System.nanoTime() - nanoTime);

	}

	@Override
	public void removeUser(long deviceId, User user) throws SmartPvException {
		LOG.info("start removeUser");
		long nanoTime = System.nanoTime();
		if (Objects.isNull(user)) {
			IllegalArgumentException ex = new IllegalArgumentException("user is null");
			LOG.error(ex.getMessage());
			throw ex;
		}
		Optional<Device> deviceById = deviceDao.findById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} Id = {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		if(deviceById.get().getUser()!= user)
			return;
		deviceById.get().setUser(null);
		deviceDao.save(deviceById.get());
		LOG.info("finished removeUser with latency={}", System.nanoTime() - nanoTime);
		
	}

}
