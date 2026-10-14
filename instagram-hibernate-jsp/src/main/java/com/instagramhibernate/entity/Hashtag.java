package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import javax.persistence.Column; // Explains this declaration or statement for training.
import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table(name = "hashtags") // Explains this declaration or statement for training.
public class Hashtag { // Explains this declaration or statement for training.
	@Id // Explains this declaration or statement for training.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
	private Long id; // Explains this declaration or statement for training.
	@Column(unique = true, nullable = false) // Explains this declaration or statement for training.
	private String name; // Explains this declaration or statement for training.

	public Hashtag() { // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long v) { // Explains this declaration or statement for training.
		id = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public String getName() { // Explains this declaration or statement for training.
		return name; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setName(String v) { // Explains this declaration or statement for training.
		name = v; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
} // Explains this declaration or statement for training.
