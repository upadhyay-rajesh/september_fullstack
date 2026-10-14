package com.instagram.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "conversation_users", uniqueConstraints = @UniqueConstraint(columnNames = { "conversation_id","user_id" }))
public class ConversationUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conversation_id", nullable = false)
	private Conversation conversation;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public ConversationUser() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User v) {
		user = v;
	}
}
