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
@Table(name = "stories") // Explains this declaration or statement for training.
public class Story { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "user_id", nullable = false) // Explains this declaration or statement for training.
	private User user; // Explains this declaration or statement for training.
	private String mediaUrl; // Explains this declaration or statement for training.
	private LocalDateTime createdAt = LocalDateTime.now(); // Explains this declaration or statement for training.
	private LocalDateTime expiresAt; // Explains this declaration or statement for training.

	public Story() { // Explains this declaration or statement for training.
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

	public String getMediaUrl() { // Explains this declaration or statement for training.
		return mediaUrl; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setMediaUrl(String v) { // Explains this declaration or statement for training.
		mediaUrl = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getCreatedAt() { // Explains this declaration or statement for training.
		return createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setCreatedAt(LocalDateTime v) { // Explains this declaration or statement for training.
		createdAt = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getExpiresAt() { // Explains this declaration or statement for training.
		return expiresAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setExpiresAt(LocalDateTime v) { // Explains this declaration or statement for training.
		expiresAt = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
