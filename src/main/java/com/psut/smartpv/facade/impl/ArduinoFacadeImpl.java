/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade.impl;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.TimeConverter;
import com.psut.smartpv.data.AiRealTimeData;
import com.psut.smartpv.data.ArduinoDataRequest;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.facade.ArduinoFacade;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.service.AiService;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.RealTimeReadingService;

/**
 * The Class ArduinoFacadeImpl.
 */
@Component
public class ArduinoFacadeImpl implements ArduinoFacade {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DeviceFacadeImpl.class);

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/** The real time reading service. */
	@Autowired
	private RealTimeReadingService realTimeReadingService;

	/** The time converter. */
	@Autowired
	private TimeConverter timeConverter;

	/** The ai service. */
	@Autowired
	private AiService aiService;

	/**
	 * Adds the data.
	 *
	 * @param imei the imei
	 * @param data the data
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void addData(String imei, ArduinoDataRequest data) throws SmartPvException {
		LOG.debug("start ArduinoFacadeImpl addData");
		long nanoTime = System.nanoTime();
		Optional<Device> deviceByImei = deviceService.getDeviceByImei(imei);
		if (!deviceByImei.isPresent()) {
			LOG.error("no device with imei ={}", imei);
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		}
		Device device = deviceByImei.get();
		realTimeReadingService.addRealTimeReadingByDeviceId(data.getOutput(), data.getTemp(), data.getHum(),
				device.getId());
		deviceService.activateDeviceById(device.getId());

		deviceService.updateDevice(device.getId(), imei, data.getLon(), data.getLat(), device.getRatedOut(),
				device.getRatedCapacity(), data.getAngleH(), data.getAngleH());
		double time = timeConverter.convertDateToDouble(new Date());
		try {
			aiService.sendReading(new AiRealTimeData(time, data.getHum(), data.getTemp(), data.getOutput()));
		} catch (Exception ex) {
			LOG.error("exception in sending data imei = {} and data = {}, Ex = {}", imei, data, ex);
		}
		LOG.info("finished ArduinoFacadeImpl addData with latency = {}", (System.nanoTime() - nanoTime));

	}

}
