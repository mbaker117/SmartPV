/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.util;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * The Class ValidationUtil.
 */
public class ValidationUtil {

	/**
	 * Instantiates a new validation util.
	 */
	private ValidationUtil() {
	}

	/**
	 * Checks if is valid email.
	 *
	 * @param email the email
	 * @return true, if is valid email
	 */
	public static boolean isValidEmail(String email) {
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(email);
	}

	/**
	 * Checks if is valid longitude.
	 *
	 * @param longitude the longitude
	 * @return true, if is valid longitude
	 */
	public static boolean isValidLongitude(double longitude) {
		return longitude >= -180 && longitude <= 180;
	}

	/**
	 * Checks if is valid latitude.
	 *
	 * @param latitude the latitude
	 * @return true, if is valid latitude
	 */
	public static boolean isValidLatitude(double latitude) {
		return latitude >= -90 && latitude <= 90;
	}

	/**
	 * Checks if is valid tilt angel.
	 *
	 * @param angle the angle
	 * @return true, if is valid tilt angel
	 */
	public static boolean isValidTiltAngel(double angle) {
		return angle >= -360 && angle <= 360;
	}

	/**
	 * Checks if is valid output.
	 *
	 * @param output the output
	 * @return true, if is valid output
	 */
	public static boolean isValidOutput(double output) {
		return output > 0;
	}

	/**
	 * Checks if is valid rated out.
	 *
	 * @param ratedOut the rated out
	 * @return true, if is valid rated out
	 */
	public static boolean isValidRatedOut(double ratedOut) {
		return ratedOut > 0;
	}

	/**
	 * Checks if is valid rated capacity.
	 *
	 * @param ratedCapacity the rated capacity
	 * @return true, if is valid rated capacity
	 */
	public static boolean isValidRatedCapacity(double ratedCapacity) {
		return ratedCapacity > 0;
	}

	/**
	 * Sum dig.
	 *
	 * @param n the n
	 * @return the int
	 */
	private static int sumDig(int n) {
		int a = 0;
		while (n > 0) {
			a = a + n % 10;
			n = n / 10;
		}
		return a;
	}

	/**
	 * Checks if is valid IMEI.
	 *
	 * @param imei the imei
	 * @return true, if is valid IMEI
	 */
	public static boolean isValidIMEI(String imei) {
		
		
		int len ;
		long imeiLong ;
		try {
			imeiLong	= Long.valueOf(imei);
			len = imei.length();
		}catch (Exception ex) {
			return false;
		}

		if (len != 15)
			return false;

		int sum = 0;
		for (int i = len; i >= 1; i--) {
			int d = (int) (imeiLong % 10);

			// Doubling every alternate digit
			if (i % 2 == 0)
				d = 2 * d;

			// Finding sum of the digits
			sum += sumDig(d);
			imeiLong = imeiLong / 10;
		}

		return (sum % 10 == 0);
	}
}
