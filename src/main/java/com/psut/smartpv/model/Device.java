/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The Class Device.
 */
@Entity
@Table(name = "DEVICE")
public class Device implements Comparable<Device> {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	/** The imei. */
	@Column(name = "IMEI", unique = true)
	@NotBlank(message = "IMEI can't be empty")
	@Size(min=15,max=15,message = "IMEI should be 15 numbers.")
	private String imei;

	/** The longitude. */
	@Column(name = "Longitude")

	private double longitude;

	/** The latitude. */
	@Column(name = "Latitude")
	private double latitude;

	/** The rated out. */
	@Column(name = "RatedOut")
	private double ratedOut;

	/** The rated capacity. */
	@Column(name = "RatedCapacity")
	private double ratedCapacity;

	/** The tilt angle horizontal. */
	@Column(name = "TiltAngleHorizontal")
	
	private double tiltAngleHorizontal;

	/** The tilt angle vertical. */
	@Column(name = "TiltAngleVertical")
	
	private double tiltAngleVertical;

	/** The activated. */
	@Column(name = "Activated")
	private boolean activated;

	/** The working. */
	@Column(name = "Working")
	private boolean working;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

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
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the rated out.
	 *
	 * @return the rated out
	 */
	public double getRatedOut() {
		return ratedOut;
	}

	/**
	 * Sets the rated out.
	 *
	 * @param ratedOut the new rated out
	 */
	public void setRatedOut(double ratedOut) {
		this.ratedOut = ratedOut;
	}

	/**
	 * Gets the rated capacity.
	 *
	 * @return the rated capacity
	 */
	public double getRatedCapacity() {
		return ratedCapacity;
	}

	/**
	 * Sets the rated capacity.
	 *
	 * @param ratedCapacity the new rated capacity
	 */
	public void setRatedCapacity(double ratedCapacity) {
		this.ratedCapacity = ratedCapacity;
	}

	/**
	 * Gets the tilt angle horizontal.
	 *
	 * @return the tilt angle horizontal
	 */
	public double getTiltAngleHorizontal() {
		return tiltAngleHorizontal;
	}

	/**
	 * Sets the tilt angle horizontal.
	 *
	 * @param tiltAngleHorizontal the new tilt angle horizontal
	 */
	public void setTiltAngleHorizontal(double tiltAngleHorizontal) {
		this.tiltAngleHorizontal = tiltAngleHorizontal;
	}

	/**
	 * Gets the tilt angle vertical.
	 *
	 * @return the tilt angle vertical
	 */
	public double getTiltAngleVertical() {
		return tiltAngleVertical;
	}

	/**
	 * Sets the tilt angle vertical.
	 *
	 * @param tiltAngleVertical the new tilt angle vertical
	 */
	public void setTiltAngleVertical(double tiltAngleVertical) {
		this.tiltAngleVertical = tiltAngleVertical;
	}

	/**
	 * Checks if is activated.
	 *
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Sets the activated.
	 *
	 * @param activated the new activated
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * Checks if is working.
	 *
	 * @return the working
	 */
	public boolean isWorking() {
		return working;
	}

	/**
	 * Sets the working.
	 *
	 * @param working the new working
	 */
	public void setWorking(boolean working) {
		this.working = working;
	}


	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(Device o) {
		// TODO Auto-generated method stub
		return Long.valueOf(getId()).compareTo(o.getId());
	}

	

}
