package com.socialbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_likes", uniqueConstraints = @UniqueConstraint(columnNames = { "post_id", "user_id" }))
public class PostLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private LocalDateTime createdAt = LocalDateTime.now();

	public PostLike() {
	}

	public Long getId() {
		return id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post v) {
		post = v;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User v) {
		user = v;
	}
}