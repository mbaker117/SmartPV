/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.PowerConverter;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.AcctualEnergyFacade;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.ExpectedReading;
import com.psut.smartpv.model.RealTimeReading;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.ExpectedReadingService;
import com.psut.smartpv.service.RealTimeReadingService;

/**
 * The Class AcctualEnergyFacadeImpl.
 */
@Component
public class AcctualEnergyFacadeImpl implements AcctualEnergyFacade {
	
	/** The device service. */
	@Autowired
	private DeviceService deviceService;
	
	/** The expected reading service. */
	@Autowired
 	private ExpectedReadingService expectedReadingService;
	
	/** The real time reading service. */
	@Autowired 
	private RealTimeReadingService realTimeReadingService;
		
	/** The power converter. */
	@Autowired
	private PowerConverter powerConverter;

	/**
	 * Calculate acctual energy.
	 *
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void calculateAcctualEnergy() throws SmartPvException {
		
		List<Device> allDevices = deviceService.getAllDevices();
		
		for(Device d : allDevices) {
			List<ExpectedReading> expectedReadingByDevice = expectedReadingService.getExpectedReadingByDevice(d.getId());

			String date = new SimpleDateFormat("YYYY-MM-DD").format((new Date()));
			for(ExpectedReading ex : expectedReadingByDevice) {
				if(ex.getDate().toString().equals(date))
					break;
				
				List<RealTimeReading> realTimeReadingByDeviceAndDate = realTimeReadingService.getRealTimeReadingByDeviceAndDate(d.getId(), ex.getDate());
				if(realTimeReadingByDeviceAndDate==null)
					continue;
				double convertPowerToEnergy = powerConverter.convertPowerToEnergy(realTimeReadingByDeviceAndDate);
				expectedReadingService.addAcctualReading(ex.getId(), convertPowerToEnergy);
			}
	
		}
		
		
	}

}
