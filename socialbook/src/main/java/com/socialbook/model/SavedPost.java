package com.socialbook.model;

import javax.persistence.*;

@Entity
@Table(name = "saved_posts")
public class SavedPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	User user;
	@ManyToOne
	Post post;

	public SavedPost() {
	}

	public Long getId() {
		return id;
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