package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import java.time.LocalDateTime; // Explains this declaration or statement for training.

import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table(name = "users") // Explains this declaration or statement for training.
public class User { // Explains this declaration or statement for training.

    @Id // Explains this declaration or statement for training.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
    private Long id; // Explains this declaration or statement for training.

    private String username; // Explains this declaration or statement for training.
    private String email; // Explains this declaration or statement for training.
    private String password; // Explains this declaration or statement for training.
    private String fullName; // Explains this declaration or statement for training.
    private String bio; // Explains this declaration or statement for training.
    private String profilePicture; // Explains this declaration or statement for training.

    private LocalDateTime createdAt; // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long id) { // Explains this declaration or statement for training.
		this.id = id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getUsername() { // Explains this declaration or statement for training.
		return username; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setUsername(String username) { // Explains this declaration or statement for training.
		this.username = username; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getEmail() { // Explains this declaration or statement for training.
		return email; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setEmail(String email) { // Explains this declaration or statement for training.
		this.email = email; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getPassword() { // Explains this declaration or statement for training.
		return password; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setPassword(String password) { // Explains this declaration or statement for training.
		this.password = password; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getFullName() { // Explains this declaration or statement for training.
		return fullName; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setFullName(String fullName) { // Explains this declaration or statement for training.
		this.fullName = fullName; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getBio() { // Explains this declaration or statement for training.
		return bio; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setBio(String bio) { // Explains this declaration or statement for training.
		this.bio = bio; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getProfilePicture() { // Explains this declaration or statement for training.
		return profilePicture; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setProfilePicture(String profilePicture) { // Explains this declaration or statement for training.
		this.profilePicture = profilePicture; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public LocalDateTime getCreatedAt() { // Explains this declaration or statement for training.
		return createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setCreatedAt(LocalDateTime createdAt) { // Explains this declaration or statement for training.
		this.createdAt = createdAt; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
    
    

    // getters and setters
} // Explains this declaration or statement for training.
