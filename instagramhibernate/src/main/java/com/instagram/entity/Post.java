package com.instagram.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@Column(length = 1000)
	private String caption;
	private String imageUrl;
	private LocalDateTime createdAt = LocalDateTime.now();

	public Post() {
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

	public String getCaption() {
		return caption;
	}

	public void setCaption(String v) {
		caption = v;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String v) {
		imageUrl = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime v) {
		createdAt = v;
	}
}
