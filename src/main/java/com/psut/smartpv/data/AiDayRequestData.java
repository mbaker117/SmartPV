/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import java.util.Date;
import java.util.List;

/**
 * The Class AiDayRequestData.
 */
public class AiDayRequestData {
	
	/** The date. */
	private Date date;
	
	/** The data. */
	private List<AiRequestData> data;
	

	/**
	 * Instantiates a new ai day request data.
	 *
	 * @param date the date.
	 * @param data the data.
	 */
	public AiDayRequestData(Date date, List<AiRequestData> data) {
		super();
		this.date = date;
		this.data = data;
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
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<AiRequestData> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<AiRequestData> data) {
		this.data = data;
	}



	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AiDayRequestData [date=" + date + ", data=" + data + "]";
	}


}
