/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.facade;

import com.psut.smartpv.exception.SmartPvException;

/**
 * The Interface AcctualEnergyFacade.
 */
public interface AcctualEnergyFacade {
	
	/**
	 * Calculate acctual energy.
	 *
	 * @throws SmartPvException the smart pv exception
	 */
	public void calculateAcctualEnergy() throws SmartPvException;

}
