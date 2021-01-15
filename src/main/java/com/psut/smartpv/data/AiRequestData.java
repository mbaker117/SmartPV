/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

/**
 * The Class AiRequestData.
 */
public class AiRequestData {

	/** The time. */
	private double time;
	
	/** The hum. */
	private double hum;
	
	/** The temp. */
	private double temp;
	
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
	 * Instantiates a new ai request data.
	 *
	 * @param time the time.
	 * @param hum  the hum.
	 * @param temp the temp.
	 */
	public AiRequestData(double time, double hum, double temp) {
		super();
		this.time = time;
		this.hum = hum;
		this.temp = temp;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AiRequestData [time=" + time + ", hum=" + hum + ", temp=" + temp + "]";
	}
	
	

}
