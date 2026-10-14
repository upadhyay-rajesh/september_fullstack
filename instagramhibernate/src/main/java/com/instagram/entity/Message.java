package com.instagram.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conversation_id", nullable = false)
	private Conversation conversation;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id", nullable = false)
	private User sender;
	@Column(length = 2000)
	private String messageText;
	private LocalDateTime sentAt = LocalDateTime.now();

	public Message() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long v) {
		id = v;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation v) {
		conversation = v;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User v) {
		sender = v;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String v) {
		messageText = v;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime v) {
		sentAt = v;
	}
}
