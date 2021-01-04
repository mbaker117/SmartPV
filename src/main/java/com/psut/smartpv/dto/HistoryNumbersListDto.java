/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dto;
import java.util.List;

/**
 * The Class HistoryNumbersListDto.
 */
public class HistoryNumbersListDto {
	
	/** The data. */
	private List<HistoryNumbersDto> data;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<HistoryNumbersDto> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<HistoryNumbersDto> data) {
		this.data = data;
	}

	/**
	 * Instantiates a new history numbers list dto.
	 *
	 * @param data the data
	 */
	public HistoryNumbersListDto(List<HistoryNumbersDto> data) {
		super();
		this.data = data;
	} 
	
	

}
