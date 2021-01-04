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
import com.psut.smartpv.model.RealTimeReading;
import com.psut.smartpv.service.RealTimeReadingService;

/**
 * The Class RealTimeReadingController.
 */
@RestController
@RequestMapping("RealTimeReadings")
public class RealTimeReadingController {
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(RealTimeReadingController.class);

	/** The real time reading service. */
	@Autowired
	private RealTimeReadingService realTimeReadingService;

	/**
	 * Adds the reading.
	 *
	 * @param output     the output
	 * @param tempreture the tempreture
	 * @param humidity   the humidity
	 * @param deviceId   the device id
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> addReading(@RequestParam(name = "output") double output,
			@RequestParam(name = "tempreture") double tempreture, @RequestParam(name = "humidity") double humidity,
			@RequestParam(name = "deviceId") long deviceId) {
		LOG.info("start RealTimeReadingController addReading ");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			realTimeReadingService.addRealTimeReadingByDeviceId(output, tempreture, humidity, deviceId);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {

			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		LOG.info("finished RealTimeReadingController addReading with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Update reading.
	 *
	 * @param id         the id
	 * @param output     the output
	 * @param tempreture the tempreture
	 * @param humidity   the humidity
	 * @param deviceId   the device id
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<String> updateReading(@RequestParam(name = "id") long id,
			@RequestParam(name = "output") double output, @RequestParam(name = "tempreture") double tempreture,
			@RequestParam(name = "humidity") double humidity, @RequestParam(name = "deviceId") long deviceId) {
		LOG.info("start RealTimeReadingController updateReading ");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			realTimeReadingService.updateRealTimeReadingByDeviceId(id, output, tempreture, humidity, deviceId);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {

			LOG.error(e.getMessage());
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		LOG.info("finished RealTimeReadingController updateReading with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Gets the all readings.
	 *
	 * @return the all readings
	 */
	@GetMapping
	public List<RealTimeReading> getAllReadings() {
		return realTimeReadingService.getAllRealTimeReadings();
	}

	/**
	 * Gets the reading by id.
	 *
	 * @param id the id
	 * @return the reading by id
	 */
	@GetMapping("/{id}")
	public RealTimeReading getReadingById(long id) {
		return realTimeReadingService.getRealTimeReadingById(id).get();
	}

	/**
	 * Gets the reading by device and date.
	 *
	 * @param deviceId the device id
	 * @param date     the date
	 * @return the reading by device and date
	 */
	@PostMapping("/byDeviceIdAndDate/{deviceId}")
	public List<RealTimeReading> getReadingByDeviceAndDate(@PathVariable(name = "deviceId") long deviceId,
			@RequestBody @Temporal(TemporalType.DATE) Date date) {
		LOG.info("start RealTimeReadingController getReadingByDeviceAndDate ");
		List<RealTimeReading> reading = null;
		long nanoTime = System.nanoTime();
		try {
			reading = realTimeReadingService.getRealTimeReadingByDeviceAndDate(deviceId, date);
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		LOG.info("finished RealTimeReadingController getReadingByDeviceAndDate with latency={}",
				System.nanoTime() - nanoTime);
		return reading;
	}

	/**
	 * Gets the reading by device.
	 *
	 * @param deviceId the device id
	 * @return the reading by device
	 */
	@GetMapping("/byDeviceId/{deviceId}")
	public List<RealTimeReading> getReadingByDevice(@PathVariable(name = "deviceId") long deviceId) {
		LOG.info("start RealTimeReadingController getReadingByDevice ");
		List<RealTimeReading> reading = null;
		long nanoTime = System.nanoTime();
		try {
			reading = realTimeReadingService.getRealTimeReadingByDevice(deviceId);
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		LOG.info("finished RealTimeReadingController getReadingByDevice with latency={}", System.nanoTime() - nanoTime);
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
		LOG.info("start RealTimeReadingController deleteReading ");
		long nanoTime = System.nanoTime();
		ResponseEntity<String> responseEntity = null;
		try {
			realTimeReadingService.deleteRealTimeReading(id);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		LOG.info("finished RealTimeReadingController deleteReading with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

}
