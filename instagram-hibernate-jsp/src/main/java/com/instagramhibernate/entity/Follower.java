package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.FetchType; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.JoinColumn; // Explains this declaration or statement for training.
import javax.persistence.ManyToOne; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.
import javax.persistence.UniqueConstraint; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table(name = "followers", uniqueConstraints = @UniqueConstraint(columnNames = { "follower_id", "following_id" })) // Explains this declaration or statement for training.
public class Follower { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "follower_id", nullable = false) // Explains this declaration or statement for training.
	private User follower; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "following_id", nullable = false) // Explains this declaration or statement for training.
	private User following; // Explains this declaration or statement for training.

	public Follower() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getFollower() { // Explains this declaration or statement for training.
		return follower; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setFollower(User v) { // Explains this declaration or statement for training.
		follower = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getFollowing() { // Explains this declaration or statement for training.
		return following; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setFollowing(User v) { // Explains this declaration or statement for training.
		following = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
