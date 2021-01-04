/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psut.smartpv.dao.ExpectedReadingDao;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.ExpectedReading;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.ExpectedReadingService;

/**
 * The Class ExpectedReadingServiceImpl.
 */
@Service
public class ExpectedReadingServiceImpl implements ExpectedReadingService {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(ExpectedReadingServiceImpl.class);
	
	/** The expected reading dao. */
	@Autowired
	private ExpectedReadingDao expectedReadingDao;

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/**
	 * Adds the expected reading by device id.
	 *
	 * @param deviceId       the device id
	 * @param expectedEnergy the expected energy
	 * @param date           the date
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void addExpectedReadingByDeviceId(long deviceId, double expectedEnergy, Date date) throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start addExpectedReadingByDeviceId");

		if (Objects.isNull(date)) {
			IllegalArgumentException ex = new IllegalArgumentException("date is null");
			LOG.error("{}", ex);
			throw ex;
		}
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		if (expectedReadingDao.findByDeviceAndDate(deviceById.get(), date).isPresent()) {
			LOG.error("{}", SmartPvExceptionType.EXPECTED_READING_ALREADY_EXIST.getMsg());
			throw new SmartPvException(SmartPvExceptionType.EXPECTED_READING_ALREADY_EXIST,
					SmartPvExceptionType.EXPECTED_READING_ALREADY_EXIST.getMsg());
		}
	

		ExpectedReading reading = new ExpectedReading();
		reading.setExpectedEnergy(expectedEnergy);
		reading.setDevice(deviceById.get());
		reading.setDate(date);
		expectedReadingDao.save(reading);
		LOG.info("finished addExpectedReadingByDeviceId with latency={}", System.nanoTime() - nanoTime);
	}

	/**
	 * Update expected reading by device id.
	 *
	 * @param id             the id
	 * @param deviceId       the device id
	 * @param expectedEnergy the expected energy
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void updateExpectedReadingByDeviceId(long id, long deviceId, double expectedEnergy) throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start updateExpectedReadingByDeviceId");
		Optional<ExpectedReading> readingById = expectedReadingDao.findById(id);
		if (!readingById.isPresent()) {
			LOG.error("{} with reading id= {}", SmartPvExceptionType.EXPECTED_READING_NOT_FOUND.getMsg(), id);
			throw new SmartPvException(SmartPvExceptionType.EXPECTED_READING_NOT_FOUND,
					SmartPvExceptionType.EXPECTED_READING_NOT_FOUND.getMsg());
		}
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		ExpectedReading reading = readingById.get();
		reading.setExpectedEnergy(expectedEnergy);
		reading.setDevice(deviceById.get());
		expectedReadingDao.save(reading);
		LOG.info("finished updateExpectedReadingByDeviceId with latency={}", System.nanoTime() - nanoTime);

	}

	/**
	 * Gets the expected reading by id.
	 *
	 * @param id the id
	 * @return the expected reading by id
	 */
	@Override
	public Optional<ExpectedReading> getExpectedReadingById(long id) {
		LOG.info("start getExpectedReadingById");
		long nanoTime = System.nanoTime();
		Optional<ExpectedReading> reading = expectedReadingDao.findById(id);
		LOG.info("finished getExpectedReadingById with latency={}", System.nanoTime() - nanoTime);
		return reading;
	}

	/**
	 * Gets the expected reading by device and date.
	 *
	 * @param deviceId the device id
	 * @param date     the date
	 * @return the expected reading by device and date
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public Optional<ExpectedReading> getExpectedReadingByDeviceAndDate(long deviceId, Date date)
			throws SmartPvException {
		LOG.info("start getExpectedReadingByDeviceAndDate");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}

		Optional<ExpectedReading> findByDeviceAndDate = expectedReadingDao.findByDeviceAndDate(deviceById.get(), date);
		LOG.info("finished getExpectedReadingByDeviceAndDate with latency={}", System.nanoTime() - nanoTime);
		return findByDeviceAndDate;
	}

	/**
	 * Gets the expected reading by device.
	 *
	 * @param deviceId the device id
	 * @return the expected reading by device
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public List<ExpectedReading> getExpectedReadingByDevice(long deviceId) throws SmartPvException {
		LOG.info("start getExpectedReadingByDevice");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceById = deviceService.getDeviceById(deviceId);
		if (!deviceById.isPresent()) {
			LOG.error("{} with device id= {}", SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg(), deviceById);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		List<ExpectedReading> findByDevice = expectedReadingDao.findByDevice(deviceById.get());
		LOG.info("finished getExpectedReadingByDevice with latency={}", System.nanoTime() - nanoTime);
		return findByDevice;
	}

	/**
	 * Gets the all expected readings.
	 *
	 * @return the all expected readings
	 */
	@Override
	public List<ExpectedReading> getAllExpectedReadings() {
		LOG.info("start getAllExpectedReadings");
		long nanoTime = System.nanoTime();
		List<ExpectedReading> findAll = expectedReadingDao.findAll();
		LOG.info("finished getAllExpectedReadings with latency={}", System.nanoTime() - nanoTime);
		return findAll;
	}

	/**
	 * Delete expected reading.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void deleteExpectedReading(long id) throws SmartPvException {
		LOG.info("start deleteExpectedReading");
		long nanoTime = System.nanoTime();
		Optional<ExpectedReading> readingById = getExpectedReadingById(id);
		if (!readingById.isPresent()) {
			LOG.error("{} with reading id= {}", SmartPvExceptionType.EXPECTED_READING_NOT_FOUND.getMsg(), readingById);
			throw new SmartPvException(SmartPvExceptionType.EXPECTED_READING_NOT_FOUND,
					SmartPvExceptionType.EXPECTED_READING_NOT_FOUND.getMsg());
		}
		expectedReadingDao.delete(readingById.get());
		LOG.info("finished getAllExpectedReadings with latency={}", System.nanoTime() - nanoTime);
	}

	/**
	 * Adds the acctual reading.
	 *
	 * @param id             the id
	 * @param acctualReading the acctual reading
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void addAcctualReading(long id, double acctualReading) throws SmartPvException {
		LOG.info("start addAcctualReading");
		long nanoTime = System.nanoTime();
		Optional<ExpectedReading> readingById = getExpectedReadingById(id);
		if (!readingById.isPresent()) {
			LOG.error("{} with reading id= {}", SmartPvExceptionType.EXPECTED_READING_NOT_FOUND.getMsg(), readingById);
			throw new SmartPvException(SmartPvExceptionType.EXPECTED_READING_NOT_FOUND,
					SmartPvExceptionType.EXPECTED_READING_NOT_FOUND.getMsg());
		}
		ExpectedReading expectedReading = readingById.get();
		expectedReading.setAcctualEnergy(acctualReading);
		expectedReadingDao.save(expectedReading);
		LOG.info("finished addAcctualReading with latency={}", System.nanoTime() - nanoTime);
		
	}
}
