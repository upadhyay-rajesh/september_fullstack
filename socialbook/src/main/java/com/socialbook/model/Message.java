package com.socialbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private User sender;
	@ManyToOne
	private User recipient;
	@Column(nullable = false, length = 3000)
	private String content;
	private boolean readFlag = false;
	private LocalDateTime sentAt = LocalDateTime.now();

	public Message() {
	}

	public Long getId() {
		return id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User v) {
		sender = v;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User v) {
		recipient = v;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String v) {
		content = v;
	}

	public boolean isReadFlag() {
		return readFlag;
	}

	public void setReadFlag(boolean v) {
		readFlag = v;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}
}