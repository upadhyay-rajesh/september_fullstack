package com.socialbook.model;

import javax.persistence.*;

@Entity
@Table(name = "social_events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String title;
	private String description;
	private String eventDate;
	@ManyToOne
	User creator;

	public Event() {
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String v) {
		title = v;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String v) {
		description = v;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String v) {
		eventDate = v;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User v) {
		creator = v;
	}
}