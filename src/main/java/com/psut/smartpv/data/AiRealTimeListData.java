/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import java.util.List;

/**
 * The Class AiRealTimeListData.
 */
public class AiRealTimeListData {

	/** The func. */
	private String func;

	/** The data. */
	private List<AiRealTimeData> data;

	/**
	 * Instantiates a new ai real time list data.
	 *
	 * @param func the func
	 * @param data the data
	 */
	public AiRealTimeListData(String func, List<AiRealTimeData> data) {
		super();
		this.func = func;
		this.data = data;
	}

	/**
	 * Gets the func.
	 *
	 * @return the func
	 */
	public String getFunc() {
		return func;
	}

	/**
	 * Sets the func.
	 *
	 * @param func the new func
	 */
	public void setFunc(String func) {
		this.func = func;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<AiRealTimeData> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<AiRealTimeData> data) {
		this.data = data;
	}

}
