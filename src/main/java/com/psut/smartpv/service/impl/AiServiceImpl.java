/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.psut.smartpv.data.AiData;
import com.psut.smartpv.data.AiInfoData;
import com.psut.smartpv.data.AiRealTimeData;
import com.psut.smartpv.data.AiRealTimeListData;
import com.psut.smartpv.data.AiRequestData;
import com.psut.smartpv.data.AiRequestListData;
import com.psut.smartpv.service.AiService;

/**
 * The Class AiServiceImpl.
 */
@Service
public class AiServiceImpl implements AiService {
	
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(AiServiceImpl.class);

	/** The Constant URL. */
	private static final String URL = "http://52.142.14.79:7895";

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Gets the power.
	 *
	 * @param data the data
	 * @return the power
	 */
	@Override
	public Optional<AiData> getPower(List<AiRequestData> data) {
		LOG.info("start getPower");
		long nanoTime = System.nanoTime();
		if (Objects.isNull(data)) {
			IllegalArgumentException exception = new IllegalArgumentException("data is null");
			LOG.error(exception.getMessage());
			throw exception;
		}
		AiRequestListData dataList = new AiRequestListData("p", data);
		AiData aiData = restTemplate.postForObject(URL, dataList, AiData.class);
		LOG.info("finished getPower with latency = {}", System.nanoTime() - nanoTime);
		return Optional.ofNullable(aiData);
	}

	/**
	 * Send reading.
	 *
	 * @param data the data
	 */
	@Override
	public void sendReading(AiRealTimeData data) {
		LOG.info("start sendReading");
		long nanoTime = System.nanoTime();
		if (Objects.isNull(data)) {
			IllegalArgumentException exception = new IllegalArgumentException("data is null");
			LOG.error(exception.getMessage());
			throw exception;
		}
		List<AiRealTimeData> list = new LinkedList<>();
		list.add(data);
		AiRealTimeListData dataList = new AiRealTimeListData("d", list);
		restTemplate.postForObject(URL, dataList, String.class);
		LOG.info("finished sendReading with latency = {}", System.nanoTime() - nanoTime);
		
	}

	@Override
	public AiInfoData getAiInfoData() {
		LOG.info("start sendReading");
		long nanoTime = System.nanoTime();
		AiRealTimeListData dataList = new AiRealTimeListData("i", null);
		AiInfoData data = restTemplate.postForObject(URL, dataList, AiInfoData.class);
		LOG.info("finished sendReading with latency = {}", System.nanoTime() - nanoTime);
		return data;
	}

}
