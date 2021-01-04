/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service;

import java.util.List;
import java.util.Optional;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Adds the user.
	 *
	 * @param email     the email
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param password  the password
	 * @throws SmartPvException the smart pv exception
	 */
	public void addUser(String email, String firstName, String lastName, String password) throws SmartPvException;

	/**
	 * Update user.
	 *
	 * @param id        the id
	 * @param email     the email
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param password  the password
	 * @throws SmartPvException the smart pv exception
	 */
	public void updateUser(long id,String email, String firstName, String lastName, String password) throws SmartPvException;
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @throws SmartPvException the smart pv exception
	 */
	public void updateUser(User user) throws SmartPvException;
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	public Optional<User> getUserById(long id);

	/**
	 * Gets the user by email.
	 *
	 * @param email the email
	 * @return the user by email
	 */
	public Optional<User> getUserByEmail(String email);

	/**
	 * Gets the user by email and password.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the user by email and password
	 */
	public Optional<User> getUserByEmailAndPassword(String email, String password);

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<User> getAllUsers();
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	public void deleteUser(long id) throws SmartPvException;
	

}
