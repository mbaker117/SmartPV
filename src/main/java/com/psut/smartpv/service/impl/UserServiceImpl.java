/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psut.smartpv.controller.DeviceController;
import com.psut.smartpv.dao.UserDao;
import com.psut.smartpv.exception.SmartPvException;
import com.psut.smartpv.exception.type.SmartPvExceptionType;
import com.psut.smartpv.model.Device;
import com.psut.smartpv.model.User;
import com.psut.smartpv.service.DeviceService;
import com.psut.smartpv.service.UserService;
import com.psut.smartpv.util.AesEncryption;
import com.psut.smartpv.util.ValidationUtil;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(DeviceController.class);

	/** The user dao. */
	@Autowired
	private UserDao userDao;

	@Autowired
	private DeviceService deviceService;
	
	/**
	 * Adds the user.
	 *
	 * @param email     the email
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param password  the password
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void addUser(String email, String firstName, String lastName, String password) throws SmartPvException {

		long nanoTime = System.nanoTime();
		LOG.info("start addRealTimeReadingByDeviceId");
		if (Objects.isNull(email)) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("email is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		if (Objects.isNull(password)) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("password is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		if (!ValidationUtil.isValidEmail(email)) {
			LOG.error(SmartPvExceptionType.INVALID_EMAIL.getMsg());
			throw new SmartPvException(SmartPvExceptionType.INVALID_EMAIL, SmartPvExceptionType.INVALID_EMAIL.getMsg());
		}
		if (userDao.findByEmail(email).isPresent()) {
			LOG.error(SmartPvExceptionType.EMAIL_ALREADY_EXIST.getMsg());
			throw new SmartPvException(SmartPvExceptionType.EMAIL_ALREADY_EXIST,
					SmartPvExceptionType.EMAIL_ALREADY_EXIST.getMsg());
		}
		User user = new User();
		user.setEmail(email);
		user.setPassword(AesEncryption.encrypt(password));
		user.setFirstName(firstName);
		user.setLastName(lastName);

		userDao.save(user);
		LOG.info("finished addRealTimeReadingByDeviceId with latency={}", System.nanoTime() - nanoTime);
	}

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
	@Override
	public void updateUser(long id, String email, String firstName, String lastName, String password)
			throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start updateUser");
		if (Objects.isNull(email)) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("email is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		if (Objects.isNull(password)) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("password is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		if (!ValidationUtil.isValidEmail(email)) {
			LOG.error(SmartPvExceptionType.INVALID_EMAIL.getMsg());
			throw new SmartPvException(SmartPvExceptionType.INVALID_EMAIL, SmartPvExceptionType.INVALID_EMAIL.getMsg());
		}

		Optional<User> findById = userDao.findById(id);
		if (!findById.isPresent()) {
			LOG.error("{} id ={}", SmartPvExceptionType.USER_NOT_FOUND.getMsg(), id);
			throw new SmartPvException(SmartPvExceptionType.USER_NOT_FOUND,
					SmartPvExceptionType.USER_NOT_FOUND.getMsg());
		}
		Optional<User> findByEmail = userDao.findByEmail(email);
		if (findByEmail.isPresent())
			if (findByEmail.get() != findById.get()) {
				LOG.error(SmartPvExceptionType.EMAIL_ALREADY_EXIST.getMsg(), id);
				throw new SmartPvException(SmartPvExceptionType.EMAIL_ALREADY_EXIST,
						SmartPvExceptionType.EMAIL_ALREADY_EXIST.getMsg());
			}
		User user = findById.get();
		user.setEmail(email);
		user.setPassword(AesEncryption.encrypt(password));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userDao.save(user);
		LOG.info("finished updateUser with latency={}", System.nanoTime() - nanoTime);

	}

	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	@Override
	public Optional<User> getUserById(long id) {
		long nanoTime = System.nanoTime();
		LOG.info("start getUserById");
		Optional<User> findById = userDao.findById(id);
		LOG.info("finished getUserById with latency={}", System.nanoTime() - nanoTime);
		return findById;
	}

	/**
	 * Gets the user by email.
	 *
	 * @param email the email
	 * @return the user by email
	 */
	@Override
	public Optional<User> getUserByEmail(String email) {
		long nanoTime = System.nanoTime();
		LOG.info("start getUserByEmail");
		if (Objects.isNull(email) || email.trim().equals("")) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("email is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;

		}
		Optional<User> findByEmail = userDao.findByEmail(email);
		LOG.info("finished getUserByEmail with latency={}", System.nanoTime() - nanoTime);

		return findByEmail;
	}

	/**
	 * Gets the user by email and password.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the user by email and password
	 */
	@Override
	public Optional<User> getUserByEmailAndPassword(String email, String password) {
		long nanoTime = System.nanoTime();
		LOG.info("start getUserByEmailAndPassword");

		if (Objects.isNull(email) || email.trim().equals("")) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("email is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		if (Objects.isNull(password) || password.trim().equals("")) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("password is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		Optional<User> findByEmailAndPassword = userDao.findByEmailAndPassword(email, AesEncryption.encrypt(password));
		LOG.info("finished getUserByEmailAndPassword with latency={}", System.nanoTime() - nanoTime);
		return findByEmailAndPassword;
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@Override
	public List<User> getAllUsers() {
		long nanoTime = System.nanoTime();
		LOG.info("start getAllUsers");
		List<User> findAll = userDao.findAll();
		LOG.info("finished getAllUsers with latency={}", System.nanoTime() - nanoTime);
		return findAll;
	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void deleteUser(long id) throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start deleteUser");
		Optional<User> userById = getUserById(id);
		if (!userById.isPresent()) {
			LOG.error("{} id ={}", SmartPvExceptionType.USER_NOT_FOUND.getMsg(), id);
			throw new SmartPvException(SmartPvExceptionType.USER_NOT_FOUND,
					SmartPvExceptionType.USER_NOT_FOUND.getMsg());
		}
		for(Device device : userById.get().getDevices())
		{
			deviceService.removeUser(device.getId(),userById.get());
		}
		
		userDao.delete(userById.get());
		LOG.info("finished deleteUser with latency={}", System.nanoTime() - nanoTime);

	}

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @throws SmartPvException the smart pv exception
	 */
	@Override
	public void updateUser(User user) throws SmartPvException {
		long nanoTime = System.nanoTime();
		LOG.info("start updateUser");
		if (Objects.isNull(user)) {
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("user is null");
			LOG.error(illegalArgumentException.getMessage());
			throw illegalArgumentException;
		}
		Optional<User> findByEmail = userDao.findByEmail(user.getEmail());
		if (findByEmail.isPresent())
			if (findByEmail.get().getId() != user.getId()) {
				LOG.error(SmartPvExceptionType.EMAIL_ALREADY_EXIST.getMsg());
				throw new SmartPvException(SmartPvExceptionType.EMAIL_ALREADY_EXIST,
						SmartPvExceptionType.EMAIL_ALREADY_EXIST.getMsg());
			}
		userDao.save(user);
		LOG.info("finished updateUser with latency={}", System.nanoTime() - nanoTime);
	}

}
