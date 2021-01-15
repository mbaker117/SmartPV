/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

/**
 * The Class ArduinoDataRequest.
 */
public class ArduinoDataRequest {
	
	/** The output. */
	private double output;
	
	/** The temp. */
	private double temp;
	
	/** The hum. */
	private double hum;
	
	/** The angle V. */
	private double angleV;
	
	/** The angle H. */
	private double angleH;
	
	/** The lon. */
	private double lon;
	
	/** The lat. */
	private double lat;
	


	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	public double getOutput() {
		return output;
	}

	/**
	 * Sets the output.
	 *
	 * @param output the new output
	 */
	public void setOutput(double output) {
		this.output = output;
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
	 * Gets the angle V.
	 *
	 * @return the angle V
	 */
	public double getAngleV() {
		return angleV;
	}

	/**
	 * Sets the angle V.
	 *
	 * @param angleV the new angle V
	 */
	public void setAngleV(double angleV) {
		this.angleV = angleV;
	}

	/**
	 * Gets the angle H.
	 *
	 * @return the angle H
	 */
	public double getAngleH() {
		return angleH;
	}

	/**
	 * Sets the angle H.
	 *
	 * @param angleH the new angle H
	 */
	public void setAngleH(double angleH) {
		this.angleH = angleH;
	}

	/**
	 * Gets the lon.
	 *
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Sets the lon.
	 *
	 * @param lon the new lon
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Sets the lat.
	 *
	 * @param lat the new lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ArduinoDataRequest [output=" + output + ", temp=" + temp + ", hum=" + hum + ", angleV=" + angleV
				+ ", angleH=" + angleH + ", lon=" + lon + ", lat=" + lat + "]";
	}
	
	
	

}
