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
	 * Gets the energy.
	 *
	 * @return the energy
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * Sets the energy.
	 *
	 * @param energy the new energy
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	

}
