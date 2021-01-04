/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psut.smartpv.dao.RealTimeReadingDao;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.RealTimeReading;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.RealTimeReadingService;

/**
 * The Class RealTimeReadingServiceImpl.
 */
@Service
public class RealTimeReadingServiceImpl implements RealTimeReadingService {
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(RealTimeReadingServiceImpl.class);
	
	/** The real time reading dao. */
	@Autowired
	private RealTimeReadingDao realTimeReadingDao;

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/**
	 * Adds the real time reading by device id.
	 *
	 * @param output     the output
	 * @param tempreture the tempreture
	 * @param humidity   the humidity
	 * @param deviceId   the device id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void addRealTimeReadingByDeviceId(double output, double tempreture, double humidity, long deviceId)
			throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start addRealTimeReadingByDeviceId");
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}

		RealTimeReading reading = new RealTimeReading();
		reading.setOutput(output);
		reading.setDevice(deviceById.get());
		reading.setHumidity(humidity);
		reading.setTempreture(tempreture);
		Date date = new Date();
		reading.setDate(date);
		reading.setTime(date);
		realTimeReadingDao.save(reading);
		LOG.info("finished addRealTimeReadingByDeviceId with latency={}", System.nanoTime() - nanoTime);
	}

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
	@Override
	public void updateRealTimeReadingByDeviceId(long id, double output, double tempreture, double humidity,
			long deviceId) throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start updateRealTimeReadingByDeviceId");
		Optional<RealTimeReading> readingById = realTimeReadingDao.findById(id);
		if (!readingById.isPresent()) {
			LOG.error("{} with reading id= {}", SmartPvExceptionType.REAL_TIME_READING_NOT_FOUND.getMsg(), id);
			throw new SmartPvException(SmartPvExceptionType.REAL_TIME_READING_NOT_FOUND,
					SmartPvExceptionType.REAL_TIME_READING_NOT_FOUND.getMsg());
		}
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		RealTimeReading reading = readingById.get();
		reading.setOutput(output);
		reading.setDevice(deviceById.get());
		reading.setHumidity(humidity);
		reading.setTempreture(tempreture);
		realTimeReadingDao.save(reading);
		LOG.info("finished updateRealTimeReadingByDeviceId with latency={}", System.nanoTime() - nanoTime);

	}

	/**
	 * Gets the real time reading by id.
	 *
	 * @param id the id
	 * @return the real time reading by id
	 */
	@Override
	public Optional<RealTimeReading> getRealTimeReadingById(long id) {
		LOG.info("start getRealTimeReadingById");
		long nanoTime = System.nanoTime();
		Optional<RealTimeReading> reading = realTimeReadingDao.findById(id);
		LOG.info("finished getRealTimeReadingById with latency={}", System.nanoTime() - nanoTime);
		return reading;
	}

	/**
	 * Gets the real time reading by device and date.
	 *
	 * @param deviceId the device id
	 * @param date     the date
	 * @return the real time reading by device and date
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public List<RealTimeReading> getRealTimeReadingByDeviceAndDate(long deviceId, Date date)
			throws SmartPvException {
		LOG.info("start getRealTimeReadingByDeviceAndDate");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}

		List<RealTimeReading> findByDeviceAndDate = realTimeReadingDao.findByDeviceAndDate(deviceById.get(), date);
		LOG.info("finished getRealTimeReadingByDeviceAndDate with latency={}", System.nanoTime() - nanoTime);
		return findByDeviceAndDate;
	}

	/**
	 * Gets the real time reading by device.
	 *
	 * @param deviceId the device id
	 * @return the real time reading by device
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public List<RealTimeReading> getRealTimeReadingByDevice(long deviceId) throws SmartPvException {
		LOG.info("start getRealTimeReadingByDevice");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		List<RealTimeReading> findByDevice = realTimeReadingDao.findByDevice(deviceById.get());
		LOG.info("finished getRealTimeReadingByDevice with latency={}", System.nanoTime() - nanoTime);
		return findByDevice;
	}

	/**
	 * Gets the all real time readings.
	 *
	 * @return the all real time readings
	 */
	@Override
	public List<RealTimeReading> getAllRealTimeReadings() {
		LOG.info("start getAllRealTimeReadings");
		long nanoTime = System.nanoTime();
		List<RealTimeReading> findAll = realTimeReadingDao.findAll();
		LOG.info("finished getAllRealTimeReadings with latency={}", System.nanoTime() - nanoTime);
		return findAll;
	}

	/**
	 * Delete real time reading.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void deleteRealTimeReading(long id) throws SmartPvException {
		LOG.info("start deleteRealTimeReading");
		long nanoTime = System.nanoTime();
		Optional<RealTimeReading> readingById = getRealTimeReadingById(id);
		if (!readingById.isPresent()) {
			LOG.error("{} with reading id= {}", SmartPvExceptionType.REAL_TIME_READING_NOT_FOUND.getMsg(), readingById);
			throw new SmartPvException(SmartPvExceptionType.REAL_TIME_READING_NOT_FOUND,
					SmartPvExceptionType.REAL_TIME_READING_NOT_FOUND.getMsg());
		}
		realTimeReadingDao.delete(readingById.get());
		LOG.info("finished getAllRealTimeReadings with latency={}", System.nanoTime() - nanoTime);
	}

}
