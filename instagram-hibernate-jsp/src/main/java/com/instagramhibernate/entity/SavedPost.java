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
@Table(name = "saved_posts", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "post_id" })) // Explains this declaration or statement for training.
public class SavedPost { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "user_id", nullable = false) // Explains this declaration or statement for training.
	private User user; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "post_id", nullable = false) // Explains this declaration or statement for training.
	private Post post; // Explains this declaration or statement for training.

	public SavedPost() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getUser() { // Explains this declaration or statement for training.
		return user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setUser(User v) { // Explains this declaration or statement for training.
		user = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Post getPost() { // Explains this declaration or statement for training.
		return post; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setPost(Post v) { // Explains this declaration or statement for training.
		post = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
