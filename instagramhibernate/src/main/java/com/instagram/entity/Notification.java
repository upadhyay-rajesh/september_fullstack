package com.instagram.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actor_id", nullable = false)
	private User actor;
	private String type;
	@Column(length = 500)
	private String message;
	private boolean isRead = false;
	private LocalDateTime createdAt = LocalDateTime.now();

	public Notification() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long v) {
		id = v;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User v) {
		user = v;
	}

	public User getActor() {
		return actor;
	}

	public void setActor(User v) {
		actor = v;
	}

	public String getType() {
		return type;
	}

	public void setType(String v) {
		type = v;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String v) {
		message = v;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean v) {
		isRead = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime v) {
		createdAt = v;
	}
}
