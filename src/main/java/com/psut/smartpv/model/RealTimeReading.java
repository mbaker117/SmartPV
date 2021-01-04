/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The Class RealTimeReading.
 */
@Entity
@Table(name="RealTimeReading")
public class RealTimeReading {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	/** The output. */
	@Column(name = "Output")
	private double output;

	/** The tempreture. */
	@Column(name = "Tempreture")
	private double tempreture;
	
	/** The humidity. */
	@Column(name = "Humidity")
	private double humidity;
	
	/** The time. */
	@Column(name = "Time")
	@Temporal(TemporalType.TIME)
	private Date time;
	
	/** The date. */
	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	private Date date;

	/** The device. */
	@ManyToOne
	private Device device;

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
	 * Gets the tempreture.
	 *
	 * @return the tempreture
	 */
	public double getTempreture() {
		return tempreture;
	}

	/**
	 * Sets the tempreture.
	 *
	 * @param tempreture the new tempreture
	 */
	public void setTempreture(double tempreture) {
		this.tempreture = tempreture;
	}

	/**
	 * Gets the humidity.
	 *
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * Sets the humidity.
	 *
	 * @param humidity the new humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the device.
	 *
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param device the new device
	 */
	public void setDevice(Device device) {
		this.device = device;
	}
	
}
