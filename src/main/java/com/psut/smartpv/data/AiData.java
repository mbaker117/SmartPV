/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The Class AiData.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AiData {

	/** The energy. */
	private double energy;

	/**
	 * Gets the power.
	 *
	 * @return the power
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * Sets the power.
	 *
	 * @param energy the new power
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	

}
