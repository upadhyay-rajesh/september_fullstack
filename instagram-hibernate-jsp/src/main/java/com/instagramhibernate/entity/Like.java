package com.instagramhibernate.entity; // Explains this declaration or statement for training.

import javax.persistence.Entity; // Explains this declaration or statement for training.
import javax.persistence.GeneratedValue; // Explains this declaration or statement for training.
import javax.persistence.GenerationType; // Explains this declaration or statement for training.
import javax.persistence.Id; // Explains this declaration or statement for training.
import javax.persistence.JoinColumn; // Explains this declaration or statement for training.
import javax.persistence.ManyToOne; // Explains this declaration or statement for training.
import javax.persistence.Table; // Explains this declaration or statement for training.
import javax.persistence.UniqueConstraint; // Explains this declaration or statement for training.

@Entity // Explains this declaration or statement for training.
@Table( // Explains this declaration or statement for training.
    name = "likes", // Explains this declaration or statement for training.
    uniqueConstraints = { // Explains this declaration or statement for training.
        @UniqueConstraint(columnNames = {"post_id", "user_id"}) // Explains this declaration or statement for training.
    } // Explains this declaration or statement for training.
) // Explains this declaration or statement for training.
public class Like { // Explains this declaration or statement for training.

    @Id // Explains this declaration or statement for training.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Explains this declaration or statement for training.
    private Long id; // Explains this declaration or statement for training.

    @ManyToOne // Explains this declaration or statement for training.
    @JoinColumn(name = "post_id") // Explains this declaration or statement for training.
    private Post post; // Explains this declaration or statement for training.

    @ManyToOne // Explains this declaration or statement for training.
    @JoinColumn(name = "user_id") // Explains this declaration or statement for training.
    private User user; // Explains this declaration or statement for training.

	public Long getId() { // Explains this declaration or statement for training.
		return id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setId(Long id) { // Explains this declaration or statement for training.
		this.id = id; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public Post getPost() { // Explains this declaration or statement for training.
		return post; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setPost(Post post) { // Explains this declaration or statement for training.
		this.post = post; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public User getUser() { // Explains this declaration or statement for training.
		return user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.

	public void setUser(User user) { // Explains this declaration or statement for training.
		this.user = user; // Explains this declaration or statement for training.
	} // Explains this declaration or statement for training.
    
    
} // Explains this declaration or statement for training.
