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
@Table(name = "messages") // Explains this declaration or statement for training.
public class Message { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "conversation_id", nullable = false) // Explains this declaration or statement for training.
	private Conversation conversation; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "sender_id", nullable = false) // Explains this declaration or statement for training.
	private User sender; // Explains this declaration or statement for training.
	@Column(length = 2000) // Explains this declaration or statement for training.
	private String messageText; // Explains this declaration or statement for training.
	private LocalDateTime sentAt = LocalDateTime.now(); // Explains this declaration or statement for training.

	public Message() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Conversation getConversation() { // Explains this declaration or statement for training.
		return conversation; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setConversation(Conversation v) { // Explains this declaration or statement for training.
		conversation = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getSender() { // Explains this declaration or statement for training.
		return sender; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setSender(User v) { // Explains this declaration or statement for training.
		sender = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getMessageText() { // Explains this declaration or statement for training.
		return messageText; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setMessageText(String v) { // Explains this declaration or statement for training.
		messageText = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getSentAt() { // Explains this declaration or statement for training.
		return sentAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setSentAt(LocalDateTime v) { // Explains this declaration or statement for training.
		sentAt = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
