/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.psut.smartpv.dto.DeviceReadingDto;
import com.psut.smartpv.dto.HistoryChartDto;
import com.psut.smartpv.dto.HistoryNumbersDto;
import com.psut.smartpv.exception.SmartPvException;

/**
 * The Interface DeviceReadingFacade.
 */
public interface DeviceReadingFacade {
	
	/**
	 * Gets the device reading by current date.
	 *
	 * @param id the id
	 * @return the device reading by current date
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	public DeviceReadingDto getDeviceReadingByCurrentDate(long id) throws SmartPvException, ParseException;
	
	/**
	 * Gets the device reading by date.
	 *
	 * @param id   the id
	 * @param date the date
	 * @return the device reading by date
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	public DeviceReadingDto getDeviceReadingByDate(long id, Date date) throws SmartPvException, ParseException;
	
	/**
	 * Gets the history numbers.
	 *
	 * @param imei the imei
	 * @return the history numbers
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	public List<HistoryNumbersDto> getHistoryNumbers(String imei) throws SmartPvException, ParseException;
	
	/**
	 * Gets the history chart.
	 *
	 * @param imei the imei
	 * @return the history chart
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	public HistoryChartDto getHistoryChart(String imei) throws SmartPvException, ParseException;

}
