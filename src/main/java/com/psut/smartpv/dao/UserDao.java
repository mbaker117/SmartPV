/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.psut.smartpv.model.User;

/**
 * The Interface UserDao.
 */
@Repository
@EnableJpaRepositories
public interface UserDao extends JpaRepository<User, Long> {
	
	/**
	 * Find by email and password.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the optional
	 */
	public Optional<User> findByEmailAndPassword(String email, String password);
	
	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the optional
	 */
	public Optional<User> findByEmail(String email);
	
}
