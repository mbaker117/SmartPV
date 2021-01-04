/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class TimeStampWeatherData.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeStampWeatherData {

	/** The dt. */
	private long dt;

	/** The main. */
	private MainWeatherData main;
	
	/** The dt txt. */
	private String dt_txt;

	/**
	 * Gets the dt txt.
	 *
	 * @return the dt txt
	 */
	public String getDt_txt() {
		return dt_txt;
	}

	/**
	 * Sets the dt txt.
	 *
	 * @param dt_txt the new dt txt
	 */
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	/**
	 * Gets the dt.
	 *
	 * @return the dt
	 */
	public long getDt() {
		return dt;
	}

	/**
	 * Sets the dt.
	 *
	 * @param dt the new dt
	 */
	public void setDt(long dt) {
		this.dt = dt;
	}

	/**
	 * Gets the main.
	 *
	 * @return the main
	 */
	public MainWeatherData getMain() {
		return main;
	}

	/**
	 * Sets the main.
	 *
	 * @param main the new main
	 */
	public void setMain(MainWeatherData main) {
		this.main = main;
	}

}
