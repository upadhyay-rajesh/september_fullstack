package com.socialbook.model;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	User reporter;
	@ManyToOne
	Post post;
	private String reason;
	private String status = "OPEN";

	public Report() {
	}

	public Long getId() {
		return id;
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User v) {
		reporter = v;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post v) {
		post = v;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String v) {
		reason = v;
	}
}