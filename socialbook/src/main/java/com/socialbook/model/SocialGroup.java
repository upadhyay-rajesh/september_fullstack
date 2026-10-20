package com.socialbook.model;

import javax.persistence.*;

@Entity
@Table(name = "social_groups")
public class SocialGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String name;
	private String description;
	@ManyToOne
	User creator;

	public SocialGroup() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String v) {
		name = v;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String v) {
		description = v;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User v) {
		creator = v;
	}
}