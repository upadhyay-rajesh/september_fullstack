package com.socialbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friendships", uniqueConstraints = @UniqueConstraint(columnNames = { "requester_id", "recipient_id" }))
public class Friendship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "requester_id")
	private User requester;
	@ManyToOne
	@JoinColumn(name = "recipient_id")
	private User recipient;
	private String status = "PENDING";
	private LocalDateTime createdAt = LocalDateTime.now();

	public Friendship() {
	}

	public Long getId() {
		return id;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User v) {
		requester = v;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User v) {
		recipient = v;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String v) {
		status = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}