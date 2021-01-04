/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dto;

/**
 * The Class HistoryNumbersDto.
 */
public class HistoryNumbersDto {
	private long id;

	/** The date. */
	private String date;
	
	/** The energy. */
	private double energy;
	
	/** The expected. */
	private double expected;



	public HistoryNumbersDto(long id, String date, double energy, double expected) {
		super();
		this.id = id;
		this.date = date;
		this.energy = energy;
		this.expected = expected;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

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

	/**
	 * Gets the expected.
	 *
	 * @return the expected
	 */
	public double getExpected() {
		return expected;
	}

	/**
	 * Sets the expected.
	 *
	 * @param expected the new expected
	 */
	public void setExpected(double expected) {
		this.expected = expected;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
