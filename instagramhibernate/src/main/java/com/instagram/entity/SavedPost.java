package com.instagram.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "saved_posts", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "post_id" }))
public class SavedPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

	public SavedPost() {
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post v) {
		post = v;
	}
}
