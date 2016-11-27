/**
 * 
 */
package com.rest.main.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * @author rahul
 *
 */
@Entity
public class User {

	
	@Id 
	@GeneratedValue
	@Column(name = "userId")
	private long userId;
	
	@Column
	private String fullName;
	
	@Column
	private String emailAddress;
	
	@Column
	private String phone;
	
	@Column
	private String password;
	
	@Column
	private String profileImageLink;
	
	@Column
	private Date dateOfBirth;
	
	@Column
	private String currentOrg;
	
	@Column
	private String bgImageLink;
	
	@Column
	private String sex;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String country;
	
	@Column
	private int noOfConnections;

	public long getUserId() {
		return userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImageLink() {
		return profileImageLink;
	}

	public void setProfileImageLink(String profileImageLink) {
		this.profileImageLink = profileImageLink;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCurrentOrg() {
		return currentOrg;
	}

	public void setCurrentOrg(String currentOrg) {
		this.currentOrg = currentOrg;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBgImageLink() {
		return bgImageLink;
	}

	public void setBgImageLink(String bgImageLink) {
		this.bgImageLink = bgImageLink;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNoOfConnections() {
		return noOfConnections;
	}

	public void setNoOfConnections(int noOfConnections) {
		this.noOfConnections = noOfConnections;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
