package com.socialbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(optional = false)
	private User author;
	@Column(nullable = false, length = 4000)
	private String content;
	private String imageUrl;
	private String visibility = "PUBLIC";
	private LocalDateTime createdAt = LocalDateTime.now();

	public Post() {
	}

	public Long getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User v) {
		author = v;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String v) {
		content = v;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String v) {
		imageUrl = v;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String v) {
		visibility = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}