/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

/**
 * The Class AiRealTimeData.
 */
public class AiRealTimeData {

	/** The time. */
	private double time;

	/** The hum. */
	private double hum;

	/** The temp. */
	private double temp;

	/** The power. */
	private double power;

	/**
	 * Instantiates a new ai real time data.
	 *
	 * @param time  the time.
	 * @param hum   the hum.
	 * @param temp  the temp.
	 * @param power the power
	 */
	public AiRealTimeData(double time, double hum, double temp, double power) {
		super();
		this.time = time;
		this.hum = hum;
		this.temp = temp;
		this.power = power;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * Gets the hum.
	 *
	 * @return the hum
	 */
	public double getHum() {
		return hum;
	}

	/**
	 * Sets the hum.
	 *
	 * @param hum the new hum
	 */
	public void setHum(double hum) {
		this.hum = hum;
	}

	/**
	 * Gets the temp.
	 *
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * Sets the temp.
	 *
	 * @param temp the new temp
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * Gets the power.
	 *
	 * @return the power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * Sets the power.
	 *
	 * @param power the new power
	 */
	public void setPower(double power) {
		this.power = power;
	}

}
