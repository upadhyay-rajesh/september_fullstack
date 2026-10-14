package com.instagram.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 50 )
	private String username;
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 255)
	private String password;
	private String fullName;
	@Column(length = 500)
	private String bio;
	private String profilePicture;
	private LocalDateTime createdAt = LocalDateTime.now();

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long v) {
		id = v;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String v) {
		username = v;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String v) {
		email = v;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String v) {
		password = v;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String v) {
		fullName = v;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String v) {
		bio = v;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String v) {
		profilePicture = v;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime v) {
		createdAt = v;
	}
}
