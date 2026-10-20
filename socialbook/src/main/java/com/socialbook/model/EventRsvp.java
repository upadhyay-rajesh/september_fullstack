package com.socialbook.model;

import javax.persistence.*;

@Entity
@Table(name = "event_rsvps")
public class EventRsvp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	Event event;
	@ManyToOne
	User user;

	public EventRsvp() {
	}

	public Long getId() {
		return id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event v) {
		event = v;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User v) {
		user = v;
	}
}