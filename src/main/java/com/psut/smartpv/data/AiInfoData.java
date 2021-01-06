/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class AiInfoData.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AiInfoData {
	
	/** The efficiency. */
	@JsonAlias("MSE")
	private double efficiency;
	
	/** The count. */
	@JsonAlias("count")
	private int count;

	/**
	 * Gets the efficiency.
	 *
	 * @return the efficiency
	 */
	public double getEfficiency() {
		return efficiency;
	}

	/**
	 * Sets the efficiency.
	 *
	 * @param efficiency the new efficiency
	 */
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
