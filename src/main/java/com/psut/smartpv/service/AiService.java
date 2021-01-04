/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service;

import java.util.List;
import java.util.Optional;

import com.psut.smartpv.data.AiData;
import com.psut.smartpv.data.AiInfoData;
import com.psut.smartpv.data.AiRealTimeData;
import com.psut.smartpv.data.AiRequestData;

/**
 * The Interface AiService.
 */
public interface AiService {
	
	/**
	 * Gets the power.
	 *
	 * @param data the data
	 * @return the power
	 */
	public Optional<AiData> getPower(List<AiRequestData> data);
	
	/**
	 * Send reading.
	 *
	 * @param data the data
	 */
	public void sendReading(AiRealTimeData data);
	
	public AiInfoData getAiInfoData();

}
