/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.ExpectedReading;
import com.psut.smartpv.service.ExpectedReadingService;

/**
 * The Class ExpectedReadingController.
 */
@RestController
@RequestMapping("expectedReadings")
public class ExpectedReadingController {
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(ExpectedReadingController.class);

	/** The expected reading service. */
	@Autowired
	private ExpectedReadingService expectedReadingService;

	/**
	 * Adds the reading.
	 *
	 * @param deviceId       the device id
	 * @param expectedEnergy the expected energy
	 * @param date           the date
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> addReading(@RequestParam(name = "deviceId") long deviceId,
			@RequestParam(name = "expectedEnergy") double expectedEnergy, @RequestParam(name = "date") Date date) {
		LOG.info("start ExpectedReadingController addReading ");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			expectedReadingService.addExpectedReadingByDeviceId(deviceId, expectedEnergy, date);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {

			LOG.error(e.getMessage());
			e.printStackTrace();
			if (e.getType() == SmartPvExceptionType.EXPECTED_READING_NOT_FOUND)
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			else
				responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		LOG.info("finished ExpectedReadingController addReading with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Update reading.
	 *
	 * @param id             the id
	 * @param deviceId       the device id
	 * @param expectedEnergy the expected energy
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<String> updateReading(@RequestParam(name = "id") long id,
			@RequestParam(name = "deviceId") long deviceId,
			@RequestParam(name = "expectedEnergy") double expectedEnergy) {
		LOG.info("start ExpectedReadingController updateReading ");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			expectedReadingService.updateExpectedReadingByDeviceId(id, deviceId, expectedEnergy);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {

			LOG.error(e.getMessage());

			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		LOG.info("finished ExpectedReadingController updateReading with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Gets the all readings.
	 *
	 * @return the all readings
	 */
	@GetMapping
	public List<ExpectedReading> getAllReadings() {
		return expectedReadingService.getAllExpectedReadings();
	}

	/**
	 * Gets the reading by id.
	 *
	 * @param id the id
	 * @return the reading by id
	 */
	@GetMapping("/{id}")
	public ExpectedReading getReadingById(long id) {
		return expectedReadingService.getExpectedReadingById(id).get();
	}

	/**
	 * Gets the reading by device and date.
	 *
	 * @param deviceId the device id
	 * @param date     the date
	 * @return the reading by device and date
	 */
	@PostMapping("/byDeviceIdAndDate/{deviceId}}")
	public ExpectedReading getReadingByDeviceAndDate(@PathVariable(name = "deviceId") long deviceId,
			@RequestBody @Temporal(TemporalType.DATE) Date date) {
		LOG.info("start ExpectedReadingController getReadingByDeviceAndDate ");
		ExpectedReading reading = null;
		long nanoTime = System.nanoTime();
		try {
			reading = expectedReadingService.getExpectedReadingByDeviceAndDate(deviceId, date).get();
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		LOG.info("finished ExpectedReadingController getReadingByDeviceAndDate with latency={}",
				System.nanoTime() - nanoTime);
		return reading;
	}

	/**
	 * Gets the reading by device.
	 *
	 * @param deviceId the device id
	 * @return the reading by device
	 */
	@GetMapping("/byDeviceId/{deviceId}}")
	public List<ExpectedReading> getReadingByDevice(@PathVariable(name = "deviceId") long deviceId) {
		LOG.info("start ExpectedReadingController getReadingByDevice ");
		List<ExpectedReading> reading = null;
		long nanoTime = System.nanoTime();
		try {
			reading = expectedReadingService.getExpectedReadingByDevice(deviceId);
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		LOG.info("finished ExpectedReadingController getReadingByDevice with latency={}", System.nanoTime() - nanoTime);
		return reading;
	}

	/**
	 * Delete reading.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReading(long id) {
		LOG.info("start ExpectedReadingController deleteReading ");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			expectedReadingService.deleteExpectedReading(id);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		LOG.info("finished ExpectedReadingController deleteReading with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

}
