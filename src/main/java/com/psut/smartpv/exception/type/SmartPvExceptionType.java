/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.exception.type;

/**
 * The Enum SmartPvExceptionType.
 */
public enum SmartPvExceptionType {

	/** The device not found. */
	DEVICE_NOT_FOUND("device not found"),
	
	/** The expected reading not found. */
	EXPECTED_READING_NOT_FOUND("expected reading not found"),

	/** The expected reading already exist. */
	EXPECTED_READING_ALREADY_EXIST("expected value already exists"),

	/** The real time reading not found. */
	REAL_TIME_READING_NOT_FOUND("real time reading not found"),
	
	/** The user not found. */
	USER_NOT_FOUND("user not found"),

	/** The email already exist. */
	EMAIL_ALREADY_EXIST("email already exist"),
	
	/** The invalid email. */
	INVALID_EMAIL("email is invalid"),

	/** The imei already exist. */
	IMEI_ALREADY_EXIST("imei is already exist"),
	
	/** The weather exception. */
	WEATHER_EXCEPTION("can't retrive weather data"),

	/** The invalid longitude. */
	INVALID_LONGITUDE("longitude is invalid"),
	
	/** The invalid latitude. */
	INVALID_LATITUDE("latitude is invalid"),
	
	/** The invalid hour. */
	INVALID_HOUR("hour is invalid"),

	/** The invalid temp. */
	INVALID_TEMP("tempreture is invalid"),
	
	/** The invalid humidity. */
	INVALID_HUMIDITY("humidity is invalid"),
	
	/** The device already exist. */
	DEVICE_ALREADY_EXIST("device already exists"), 
 /** The invalid imei. */
 INVALID_IMEI("imei is invalid"), 
 /** The device already used. */
 DEVICE_ALREADY_USED("device is already used by other user");

	/** The msg. */
	private String msg;

	/**
	 * Instantiates a new smart pv exception type.
	 *
	 * @param msg the msg.
	 */
	private SmartPvExceptionType(String msg) {
		this.msg = msg;
	}

	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Sets the msg.
	 *
	 * @param msg the new msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
