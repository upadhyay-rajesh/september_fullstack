package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import java.time.LocalDateTime; // Explains this declaration or statement for training.

import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.JoinColumn; // Explains this declaration or statement for training.
import javax.persistence.ManyToOne; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table(name = "posts") // Explains this declaration or statement for training.
public class Post { // Explains this declaration or statement for training.

    @Id // Explains this declaration or statement for training.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
    private Long id; // Explains this declaration or statement for training.

    private String caption; // Explains this declaration or statement for training.
    private String imageUrl; // Explains this declaration or statement for training.

    @ManyToOne // Explains this declaration or statement for training.
    @JoinColumn(name = "user_id") // Explains this declaration or statement for training.
    private User user; // Explains this declaration or statement for training.

    private LocalDateTime createdAt; // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long id) { // Explains this declaration or statement for training.
		this.id = id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getCaption() { // Explains this declaration or statement for training.
		return caption; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setCaption(String caption) { // Explains this declaration or statement for training.
		this.caption = caption; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getImageUrl() { // Explains this declaration or statement for training.
		return imageUrl; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setImageUrl(String imageUrl) { // Explains this declaration or statement for training.
		this.imageUrl = imageUrl; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getUser() { // Explains this declaration or statement for training.
		return user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setUser(User user) { // Explains this declaration or statement for training.
		this.user = user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getCreatedAt() { // Explains this declaration or statement for training.
		return createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setCreatedAt(LocalDateTime createdAt) { // Explains this declaration or statement for training.
		this.createdAt = createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
    
    
} // Explains this declaration or statement for training.
