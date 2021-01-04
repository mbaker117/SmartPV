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
 * The Class ExpectedReading.
 */
@Entity
@Table(name = "EXPECTED_READING")
public class ExpectedReading {
	
	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	/** The expected energy. */
	@Column(name = "expectedEnergy")
	private double expectedEnergy;
		
	
	/** The acctual energy. */
	@Column(name = "acctualEnergy")
	private double acctualEnergy;
	
	/** The date. */
	@Column(name = "date")
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

	/**
	 * Gets the expected energy.
	 *
	 * @return the expected energy
	 */
	public double getExpectedEnergy() {
		return expectedEnergy;
	}

	/**
	 * Sets the expected energy.
	 *
	 * @param expectedEnergy the new expected energy
	 */
	public void setExpectedEnergy(double expectedEnergy) {
		this.expectedEnergy = expectedEnergy;
	}

	/**
	 * Gets the acctual energy.
	 *
	 * @return the acctual energy
	 */
	public double getAcctualEnergy() {
		return acctualEnergy;
	}

	/**
	 * Sets the acctual energy.
	 *
	 * @param acctualEnergy the new acctual energy
	 */
	public void setAcctualEnergy(double acctualEnergy) {
		this.acctualEnergy = acctualEnergy;
	}
	
	

}
