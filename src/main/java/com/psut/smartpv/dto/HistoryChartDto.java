/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dto;

import java.util.List;

/**
 * The Class HistoryChartDto.
 */
public class HistoryChartDto {
	
	/** The energy data. */
	private List<Double> energyData;
	

	/** The expected data. */
	private List<Double> expectedData;
	
	/** The date. */
	private List<String> date;

	/**
	 * Gets the energy data.
	 *
	 * @return the energy data
	 */
	public List<Double> getEnergyData() {
		return energyData;
	}

	/**
	 * Sets the energy data.
	 *
	 * @param energyData the new energy data
	 */
	public void setEnergyData(List<Double> energyData) {
		this.energyData = energyData;
	}

	/**
	 * Gets the expected data.
	 *
	 * @return the expected data
	 */
	public List<Double> getExpectedData() {
		return expectedData;
	}

	/**
	 * Sets the expected data.
	 *
	 * @param expectedData the new expected data
	 */
	public void setExpectedData(List<Double> expectedData) {
		this.expectedData = expectedData;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public List<String> getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(List<String> date) {
		this.date = date;
	}




	
	

}
