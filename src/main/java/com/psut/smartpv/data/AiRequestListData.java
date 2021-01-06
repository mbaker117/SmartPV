/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import java.util.List;

/**
 * The Class AiRequestListData.
 */
public class AiRequestListData {
	
	/** The func. */
	private String func;

	/** The data. */
	private List<AiRequestData> data;

	/**
	 * Instantiates a new ai request list data.
	 *
	 * @param func the func.
	 * @param data the data.
	 */
	public AiRequestListData(String func, List<AiRequestData> data) {
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

}
