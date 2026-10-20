package com.socialbook.model;

import javax.persistence.*;

@Entity
@Table(name = "group_members")
public class GroupMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	SocialGroup group;
	@ManyToOne
	User user;

	public GroupMember() {
	}

	public Long getId() {
		return id;
	}

	public SocialGroup getGroup() {
		return group;
	}

	public void setGroup(SocialGroup v) {
		group = v;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User v) {
		user = v;
	}
}