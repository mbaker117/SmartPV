/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class WeatherData.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
	
	/** The cod. */
	private int cod;
	
	/** The list. */
	private List<TimeStampWeatherData> list;
	

	/**
	 * Gets the cod.
	 *
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Sets the cod.
	 *
	 * @param cod the new cod
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public List<TimeStampWeatherData> getList() {
		return list;
	}

	/**
	 * Sets the list.
	 *
	 * @param list the new list
	 */
	public void setList(List<TimeStampWeatherData> list) {
		this.list = list;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "WeatherData [cod=" + cod + ", list=" + list + "]";
	}
	
	
	
	

}
