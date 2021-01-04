/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.ExpectedReading;

/**
 * The Interface ExpectedReadingDao.
 */
@Repository
@EnableJpaRepositories
public interface ExpectedReadingDao extends JpaRepository<ExpectedReading, Long>{
	
	/**
	 * Find by device and date.
	 *
	 * @param device the device
	 * @param date   the date
	 * @return the optional
	 */
	public Optional<ExpectedReading> findByDeviceAndDate(Device device, Date date);
	
	/**
	 * Find by device.
	 *
	 * @param device the device
	 * @return the list
	 */
	public List<ExpectedReading> findByDevice(Device device);

}
