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
	
	/** The error. */
	@JsonAlias("MSE")
	private double error;
	
	/** The count. */
	@JsonAlias("count")
	private int count;

	


	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public double getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(double error) {
		this.error = error;
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
