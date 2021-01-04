/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.exception;

import com.psut.smartpv.exception.type.SmartPvExceptionType;

/**
 * The Class SmartPvException.
 */
public class SmartPvException  extends Exception{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -874203657363364424L;
	
	/** The type. */
	private final SmartPvExceptionType type;

	/**
	 * Instantiates a new smart pv exception.
	 *
	 * @param type the type.
	 * @param msg  the msg
	 */
	public SmartPvException(SmartPvExceptionType type, String msg) {
		super(msg);
		this.type = type;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public SmartPvExceptionType getType() {
		return type;
	}
	
	

}
