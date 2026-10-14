package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import java.time.LocalDateTime; // Explains this declaration or statement for training.

import javax.persistence.Column; // Explains this declaration or statement for training.
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
@Table(name = "story_views", uniqueConstraints = @UniqueConstraint(columnNames = { "story_id", "user_id" })) // Explains this declaration or statement for training.
public class StoryView { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "story_id", nullable = false) // Explains this declaration or statement for training.
	private Story story; // Explains this declaration or statement for training.
	@ManyToOne(fetch = FetchType.LAZY) // Explains this declaration or statement for training.
	@JoinColumn(name = "user_id", nullable = false) // Explains this declaration or statement for training.
	private User user; // Explains this declaration or statement for training.
	private LocalDateTime viewedAt = LocalDateTime.now(); // Explains this declaration or statement for training.

	public StoryView() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Story getStory() { // Explains this declaration or statement for training.
		return story; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setStory(Story v) { // Explains this declaration or statement for training.
		story = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getUser() { // Explains this declaration or statement for training.
		return user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setUser(User v) { // Explains this declaration or statement for training.
		user = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getViewedAt() { // Explains this declaration or statement for training.
		return viewedAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setViewedAt(LocalDateTime v) { // Explains this declaration or statement for training.
		viewedAt = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
