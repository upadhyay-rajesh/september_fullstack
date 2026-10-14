package com.instagram.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "followers", uniqueConstraints = @UniqueConstraint(columnNames = { "follower_id", "following_id" }))
public class Follower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "follower_id", nullable = false)
	private User follower;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "following_id", nullable = false)
	private User following;

	public Follower() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long v) {
		id = v;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User v) {
		follower = v;
	}

	public User getFollowing() {
		return following;
	}

	public void setFollowing(User v) {
		following = v;
	}
}
