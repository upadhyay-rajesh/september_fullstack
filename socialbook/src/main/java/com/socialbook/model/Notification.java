package com.socialbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private User recipient;
	private String message;
	private boolean seen = false;
	private LocalDateTime createdAt = LocalDateTime.now();

	public Notification() {
	}

	public Long getId() {
		return id;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User v) {
		recipient = v;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String v) {
		message = v;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean v) {
		seen = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}