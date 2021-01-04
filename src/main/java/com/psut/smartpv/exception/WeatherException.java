/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.exception;

/**
 * The Class WeatherException.
 */
public class WeatherException  extends RuntimeException{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8464290788926932405L;

	/** The code. */
	private final int code;
	
	/** The msg. */
	private final String msg;

	/**
	 * Instantiates a new weather exception.
	 *
	 * @param code the code.
	 * @param msg  the msg.
	 */
	public WeatherException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	
	
}
