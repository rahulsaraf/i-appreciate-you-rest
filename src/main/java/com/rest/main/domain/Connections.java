/**
 * 
 */
package com.rest.main.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author rahul
 *
 */
@Entity
public class Connections {
	
	@Id 
	@GeneratedValue
	@Column(name = "connId")
	private long connId;
	
	@ManyToOne
	@JoinColumn(name = "requesterId", nullable = false)
	@JsonBackReference
	private User requesterId;
	
	@ManyToOne
	@JoinColumn(name = "accepterId", nullable = false)
	@JsonBackReference
	private User accepterId;
	
	@Column
	private Date connCreationTime;
	
	@Column
	private boolean isActive;

	public User getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(User requesterId) {
		this.requesterId = requesterId;
	}

	public User getAccepterId() {
		return accepterId;
	}

	public void setAccepterId(User accepterId) {
		this.accepterId = accepterId;
	}

	public Date getConnCreationTime() {
		return connCreationTime;
	}

	public void setConnCreationTime(Date connCreationTime) {
		this.connCreationTime = connCreationTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public long getConnId() {
		return connId;
	}
	
	
}
