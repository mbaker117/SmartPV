/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.DeviceFacade;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.service.DeviceService;

/**
 * The Class DeviceFacadeImpl.
 */
@Component
public class DeviceFacadeImpl implements DeviceFacade {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DeviceFacadeImpl.class);

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/**
	 * Reset devices.
	 */
	@Override
	public void resetDevices() {
		LOG.debug("start DeviceFacade resetDevices");
		long nanoTime = System.nanoTime();

		List<Device> devices = deviceService.getAllActivatedDevices();
		for (Device d : devices) {
			try {
				if (!d.isWorking())
					deviceService.deActivateDevice(d.getId());
				deviceService.setWorking(d.getId(), false);
			} catch (SmartPvException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		}
		LOG.info("finished DeviceFacadeImpl resetDevices with latency = {}", (System.nanoTime() - nanoTime));
	}

}
