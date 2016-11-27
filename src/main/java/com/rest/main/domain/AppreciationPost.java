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
public class AppreciationPost {

	
	@ManyToOne
	@JoinColumn(name = "senderId", nullable = false)
	@JsonBackReference
	private User senderId;
	

	@ManyToOne
	@JoinColumn(name = "receiverId", nullable = false)
	@JsonBackReference
	private User receiverId;
	@Column
	private String message;
	@Column
	private int happy;
	@Column
	private int helpful;
	@Column
	private int easygoing;
	@Column
	private int fun;
	@Column
	private int respectful;
	@Column
	private int confident;
	@Column
	private int emotional;
	@Column
	private int motivated;
	@Column
	private int compassionate;
	
	@Id 
	@GeneratedValue
	@Column(name = "postId")
	private Long postId;
	
	@Column
	private Date postCreationDate;
	
	
}
