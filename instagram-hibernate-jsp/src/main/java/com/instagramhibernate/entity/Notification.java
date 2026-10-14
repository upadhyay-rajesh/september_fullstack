package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import java.time.LocalDateTime; // Explains this declaration or statement for training.

import javax.persistence.Column; // Explains this declaration or statement for training.
import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.FetchType; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.JoinColumn; // Explains this declaration or statement for training.
import javax.persistence.ManyToOne; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table(name = "notifications") // Explains this declaration or statement for training.
public class Notification { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "user_id", nullable = false) // Explains this declaration or statement for training.
	private User user; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "actor_id", nullable = false) // Explains this declaration or statement for training.
	private User actor; // Explains this declaration or statement for training.
	private String type; // Explains this declaration or statement for training.
	@Column(length = 500) // Explains this declaration or statement for training.
	private String message; // Explains this declaration or statement for training.
	private boolean isRead = false; // Explains this declaration or statement for training.
	private LocalDateTime createdAt = LocalDateTime.now(); // Explains this declaration or statement for training.

	public Notification() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getUser() { // Explains this declaration or statement for training.
		return user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setUser(User v) { // Explains this declaration or statement for training.
		user = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getActor() { // Explains this declaration or statement for training.
		return actor; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setActor(User v) { // Explains this declaration or statement for training.
		actor = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getType() { // Explains this declaration or statement for training.
		return type; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setType(String v) { // Explains this declaration or statement for training.
		type = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getMessage() { // Explains this declaration or statement for training.
		return message; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setMessage(String v) { // Explains this declaration or statement for training.
		message = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public boolean isRead() { // Explains this declaration or statement for training.
		return isRead; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setRead(boolean v) { // Explains this declaration or statement for training.
		isRead = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getCreatedAt() { // Explains this declaration or statement for training.
		return createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setCreatedAt(LocalDateTime v) { // Explains this declaration or statement for training.
		createdAt = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
