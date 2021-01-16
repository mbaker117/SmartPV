/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.facade.DeviceFacade;
import com.psut.smartpv.facade.ExpectedReadingFacade;
import com.psut.smartpv.facade.impl.AcctualEnergyFacadeImpl;

/**
 * The Class MainJob.
 */
@Component
public class MainJob {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(MainJob.class);

	/** The Constant dateFormat. */
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/** The expected reading facade. */
	@Autowired
	private ExpectedReadingFacade expectedReadingFacade;

	/** The acctual energy facade impl. */
	@Autowired
	private AcctualEnergyFacadeImpl acctualEnergyFacadeImpl;

	/** The device facade. */
	@Autowired
	private DeviceFacade deviceFacade;

	/**
	 * Adds the expected power.
	 */

	@Scheduled(cron = "0 5 0 * * ?")
	public void addExpectedPower() {
		LOG.debug("start cron job addExpectedPower");
		LOG.info("The time is now {}", dateFormat.format(new Date()));
		try {
			expectedReadingFacade.addExpectedReadingToAllDevices();
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		updateAcctualEnergy();
		LOG.debug("end cron job addExpectedPower");
		LOG.info("The time is now {}", dateFormat.format(new Date()));
	}

	/**
	 * Update acctual energy.
	 */
	public void updateAcctualEnergy() {
		LOG.debug("start cron job updateAcctualEnergy");
		LOG.info("The time is now {}", dateFormat.format(new Date()));
		try {
			acctualEnergyFacadeImpl.calculateAcctualEnergy();
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		LOG.debug("end cron job updateAcctualEnergy");
		LOG.info("The time is now {}", dateFormat.format(new Date()));
	}

	/**
	 * Reset working device.
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	public void resetWorkingDevice() {
		LOG.debug("start cron job resetWorkingDevice");
		LOG.info("The time is now {}", dateFormat.format(new Date()));
		deviceFacade.resetDevices();
		LOG.info("The time is now {}", dateFormat.format(new Date()));
	}

}
