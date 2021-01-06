/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

/**
 * The Class User.
 */
@Entity
@Table(name = "USER")
public class User {

	/** The id. */
	@Id
	@SequenceGenerator(name="user_generator", sequenceName = "user_generator", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	

	@Column(name = "id")
	private long id;

	/** The password. */
	@NotBlank(message = "Password can't be empty")
	private String password;

	/** The first name. */
	@NotNull
	@NotBlank(message = "first name cannot be less than 1 character")
	@Column(name = "FirstName")
	private String firstName;

	/** The last name. */
	@NotNull
	@NotBlank(message = "last name cannot be less than 1 character")
	@Column(name = "LastName")
	private String lastName;

	/** The email. */
	@Column(name = "Email", unique = true)
	@NotNull
	@NotBlank(message = "email cannot be empty")
	private String email;

	/** The devices. */
	@OneToMany(targetEntity = Device.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Device> devices;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the devices.
	 *
	 * @return the devices
	 */
	public Set<Device> getDevices() {
		return devices;
	}

	/**
	 * Sets the devices.
	 *
	 * @param devices the new devices
	 */
	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

}
