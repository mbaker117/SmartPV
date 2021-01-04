/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dto;

/**
 * The Class DeviceReadingDto.
 */
public class DeviceReadingDto {

	/** The imei. */
	private String imei;

	/** The temp. */
	private double temp;

	/** The hum. */
	private double hum;

	/** The energy. */
	private double energy;

	/** The expected. */
	private double expected;

	/** The status. */
	private boolean status;

	/** The lon. */
	private double lon;

	/** The lat. */
	private double lat;

	/** The angle H. */
	private double angleH;

	/** The angle V. */
	private double angleV;

	/**
	 * Gets the imei.
	 *
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the imei.
	 *
	 * @param imei the new imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
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

	/**
	 * Checks if is status.
	 *
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
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

}
