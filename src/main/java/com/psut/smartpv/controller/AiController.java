/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.data.AiData;
import com.psut.smartpv.data.AiInfoData;
import com.psut.smartpv.data.AiRealTimeData;
import com.psut.smartpv.data.AiRequestData;
import com.psut.smartpv.service.AiService;

/**
 * The Class AiController.
 */
@RestController
@RequestMapping("/ai")
public class AiController {

	/** The ai service. */
	@Autowired
	private AiService aiService;

	/**
	 * Gets the expected power.
	 *
	 * @param time     the time
	 * @param temp     the temp
	 * @param humidity the humidity
	 * @return the expected power
	 */
	@PostMapping
	public AiData getExpectedPower(@RequestParam(name = "time") double time,
			@RequestParam(name = "tempreture") double temp, @RequestParam(name = "humidity") double humidity) {
		AiRequestData data = new AiRequestData(time, humidity, temp);
		List<AiRequestData> list = new ArrayList<AiRequestData>();
		list.add(data);
		list.add(data);
		list.add(data);
		list.add(data);
		list.add(data);
		return aiService.getPower(list).get();
	}

	/**
	 * Send data.
	 *
	 * @param time     the time
	 * @param temp     the temp
	 * @param humidity the humidity
	 * @param power    the power
	 */
	@PostMapping("/add")
	public void sendData(@RequestParam(name = "time") double time, @RequestParam(name = "tempreture") double temp,
			@RequestParam(name = "humidity") double humidity, @RequestParam(name = "power") double power) {
		AiRealTimeData data = new AiRealTimeData(time, humidity, temp, power);
		aiService.sendReading(data);

	}
	
	
	@PostMapping("/info")
	public AiInfoData getAiInfoData() {
		
		return aiService.getAiInfoData();

	}

}
