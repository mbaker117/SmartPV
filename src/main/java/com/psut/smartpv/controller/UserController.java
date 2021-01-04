/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.User;
import com.psut.smartpv.service.UserService;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Adds the user.
	 *
	 * @param email     the email
	 * @param password  the password
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> addUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, @RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		long nanoTime = System.nanoTime();
		LOG.info("start  UserController addUser");
		ResponseEntity<String> responseEntity = null;
		try {
			userService.addUser(email, firstName, lastName, password);
			responseEntity = ResponseEntity.ok("ok");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
		LOG.info("finished UserController addUser with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Update user.
	 *
	 * @param id        the id
	 * @param email     the email
	 * @param password  the password
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestParam(name = "id") long id,
			@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
			@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		long nanoTime = System.nanoTime();
		LOG.info("start  UserController updateUser");
		ResponseEntity<String> responseEntity = null;
		try {
			userService.updateUser(id, email, firstName, lastName, password);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			if (e.getType() == SmartPvExceptionType.USER_NOT_FOUND)
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			else
				responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		LOG.info("finished UserController updateUser with latency={}", System.nanoTime() - nanoTime);
		return responseEntity;
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping
	public List<User> getAllUsers() {
		long nanoTime = System.nanoTime();
		LOG.info("start  UserController getAllUsers");
		List<User> allUsers = userService.getAllUsers();
		LOG.info("finished UserController getAllUsers with latency={}", System.nanoTime() - nanoTime);
		return allUsers;
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") long id) {
		long nanoTime = System.nanoTime();
		LOG.info("start  UserController getUser");
		User user = userService.getUserById(id).get();
		LOG.info("finished UserController getUser with latency={}", System.nanoTime() - nanoTime);
		return user;
	}

	/**
	 * Checks if is valid user.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return true, if is valid user
	 */
	@PostMapping("/mobile/isValid")
	public boolean isValidUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		long nanoTime = System.nanoTime();
		LOG.info("start  UserController isValidUser");
		boolean present = false;
		try {
		 present = userService.getUserByEmailAndPassword(email, password).isPresent();
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
		}
		LOG.info("finished UserController isValidUser with latency={}", System.nanoTime() - nanoTime);
		return present;
	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		long nanoTime = System.nanoTime();
		LOG.info("start  UserController deleteUser");
		ResponseEntity<String> responseEntity = null;
		try {
			userService.deleteUser(id);
			responseEntity = ResponseEntity.ok("");
		} catch (SmartPvException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		LOG.info("finished UserController deleteUser with latency=", System.nanoTime() - nanoTime);
		return responseEntity;
	}

}
