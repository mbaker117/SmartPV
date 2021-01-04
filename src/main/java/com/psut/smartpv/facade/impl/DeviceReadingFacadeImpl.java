/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psut.smartpv.converter.PowerConverter;
import com.psut.smartpv.dto.DeviceReadingDto;
import com.psut.smartpv.dto.HistoryChartDto;
import com.psut.smartpv.dto.HistoryNumbersDto;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.facade.DeviceReadingFacade;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.ExpectedReading;
import com.psut.smartpv.model.RealTimeReading;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.ExpectedReadingService;
import com.psut.smartpv.service.RealTimeReadingService;

/**
 * The Class DeviceReadingFacadeImpl.
 */
@Component
public class DeviceReadingFacadeImpl implements DeviceReadingFacade {

	/** The real time reading service. */
	@Autowired
	private RealTimeReadingService realTimeReadingService;

	/** The expected reading service. */
	@Autowired
	private ExpectedReadingService expectedReadingService;

	/** The device service. */
	@Autowired
	private DeviceService deviceService;

	/** The power converter. */
	@Autowired
	private PowerConverter powerConverter;

	/**
	 * Gets the device reading by current date.
	 *
	 * @param id the id
	 * @return the device reading by current date
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@Override
	public DeviceReadingDto getDeviceReadingByCurrentDate(long id) throws SmartPvException, ParseException {
		/*
		 * Date date = new Date();
		 */

		return getDeviceReadingByDate(id, new Date());

	}

	/**
	 * Gets the device reading by date.
	 *
	 * @param id   the id
	 * @param date the date
	 * @return the device reading by date
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@Override
	public DeviceReadingDto getDeviceReadingByDate(long id, Date date) throws SmartPvException, ParseException {
		Optional<Device> deviceById = deviceService.getDeviceById(id);
		if (!deviceById.isPresent())
			throw new SmartPvException(SmartPvExceptionType.DEVICE_NOT_FOUND,
					SmartPvExceptionType.DEVICE_NOT_FOUND.getMsg());
		Device device = deviceById.get();
		DeviceReadingDto dto = new DeviceReadingDto();
		dto.setImei(device.getImei());
		dto.setLat(device.getLatitude());
		dto.setLon(device.getLongitude());
		dto.setAngleH(device.getTiltAngleHorizontal());
		dto.setAngleV(device.getTiltAngleVertical());

		Optional<ExpectedReading> expectedReadingByDeviceAndDate = expectedReadingService
				.getExpectedReadingByDeviceAndDate(device.getId(), date);
		if (expectedReadingByDeviceAndDate.isPresent())
			dto.setExpected(expectedReadingByDeviceAndDate.get().getExpectedEnergy());
		List<RealTimeReading> realTimeReadingByDeviceAndDate = realTimeReadingService
				.getRealTimeReadingByDeviceAndDate(device.getId(), date);
		if (realTimeReadingByDeviceAndDate != null) {
			dto.setEnergy(Math.abs(powerConverter.convertPowerToEnergy(realTimeReadingByDeviceAndDate)));
			if (realTimeReadingByDeviceAndDate.size() > 0) {
				RealTimeReading realTimeReading = realTimeReadingByDeviceAndDate
						.get(realTimeReadingByDeviceAndDate.size() - 1);
				dto.setTemp(realTimeReading.getTempreture());
				dto.setHum(realTimeReading.getHumidity());
			}

		}
		dto.setStatus(device.isActivated());
		return dto;
	}

	/**
	 * Gets the history numbers.
	 *
	 * @param imei the imei
	 * @return the history numbers
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@Override
	public List<HistoryNumbersDto> getHistoryNumbers(String imei) throws SmartPvException, ParseException {
		Optional<Device> deviceByImei = deviceService.getDeviceByImei(imei);
		if (!deviceByImei.isPresent())
			return null;
		List<ExpectedReading> expectedReadingByDevice = expectedReadingService
				.getExpectedReadingByDevice(deviceByImei.get().getId());
		List<HistoryNumbersDto> data = new LinkedList<HistoryNumbersDto>();

		String date = new SimpleDateFormat("YYYY-MM-DD").format((new Date()));

		for (ExpectedReading ex : expectedReadingByDevice) {

			if (ex.getDate().toString().equals(date))
				ex.setAcctualEnergy(Math.abs(powerConverter.convertPowerToEnergy(realTimeReadingService.getRealTimeReadingByDeviceAndDate(deviceByImei.get().getId(), new Date()))));

			data.add(new HistoryNumbersDto(ex.getId(),ex.getDate().toString(), ex.getAcctualEnergy(), ex.getExpectedEnergy()));
		}
		return data;
	}

	/**
	 * Gets the history chart.
	 *
	 * @param imei the imei
	 * @return the history chart
	 * @throws SmartPvException the smart pv exception
	 * @throws ParseException   the parse exception
	 */
	@Override
	public HistoryChartDto getHistoryChart(String imei) throws SmartPvException, ParseException {
		List<HistoryNumbersDto> historyNumbers = getHistoryNumbers(imei);
		List<Double> energyData = new LinkedList<Double>();
		List<String> dates = new LinkedList<String>();
		List<Double> expectedData = new LinkedList<Double>();
		HistoryChartDto chart = new HistoryChartDto();
		DecimalFormat formater = new DecimalFormat("##.#");
		String date = new SimpleDateFormat("YYYY-MM-DD").format((new Date()));
		boolean flag = false;
		for (HistoryNumbersDto history : historyNumbers) {
			expectedData.add(Double.valueOf(formater.format(history.getExpected())));
			dates.add(history.getDate());
			if (!flag) {
				if (history.getDate().equals(date))
					flag = true;
				energyData.add(Double.valueOf(formater.format(history.getEnergy())));
			}
		}
		chart.setEnergyData(energyData);
		chart.setExpectedData(expectedData);
		chart.setDate(dates);
		return chart;
	}

}
