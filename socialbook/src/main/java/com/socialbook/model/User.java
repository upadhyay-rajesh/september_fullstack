package com.socialbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String fullName;
	private String bio;
	private String city;
	private String profileImageUrl;
	private String privacy = "PUBLIC";
	private LocalDateTime joinedAt = LocalDateTime.now();

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long v) {
		id = v;
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

	public String getCity() {
		return city;
	}

	public void setCity(String v) {
		city = v;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String v) {
		profileImageUrl = v;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String v) {
		privacy = v;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}
}