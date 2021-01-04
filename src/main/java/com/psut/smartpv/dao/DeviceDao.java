/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.psut.smartpv.model.Device;

/**
 * The Interface DeviceDao.
 */
@Repository
@EnableJpaRepositories
public interface DeviceDao extends JpaRepository<Device, Long> {

	/**
	 * Find by imei.
	 *
	 * @param imei the imei
	 * @return the optional
	 */
	public Optional<Device> findByImei(String imei);

	/**
	 * Find by activated.
	 *
	 * @param activated the activated
	 * @return the list
	 */
	public List<Device> findByActivated(boolean activated);

}
