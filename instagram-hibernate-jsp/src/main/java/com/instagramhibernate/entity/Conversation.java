package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import java.time.LocalDateTime; // Explains this declaration or statement for training.

import javax.persistence.Column; // Explains this declaration or statement for training.
import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table(name = "conversations") // Explains this declaration or statement for training.
public class Conversation { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	private LocalDateTime createdAt = LocalDateTime.now(); // Explains this declaration or statement for training.

	public Conversation() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getCreatedAt() { // Explains this declaration or statement for training.
		return createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setCreatedAt(LocalDateTime v) { // Explains this declaration or statement for training.
		createdAt = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
