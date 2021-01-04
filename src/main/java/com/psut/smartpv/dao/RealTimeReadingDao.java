/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.RealTimeReading;

/**
 * The Interface RealTimeReadingDao.
 */
@Repository
@EnableJpaRepositories
public interface RealTimeReadingDao extends JpaRepository<RealTimeReading, Long> {

	/**
	 * Find by device and date.
	 *
	 * @param device the device
	 * @param date   the date
	 * @return the list
	 */
	public List<RealTimeReading> findByDeviceAndDate(Device device, Date date);

	/**
	 * Find by device.
	 *
	 * @param device the device
	 * @return the list
	 */
	public List<RealTimeReading> findByDevice(Device device);

}
