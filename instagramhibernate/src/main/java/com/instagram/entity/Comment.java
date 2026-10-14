package com.instagram.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="comments")
public class Comment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="post_id", nullable=false) private Post post;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="user_id", nullable=false) private User user;
    @Column(length=1000) private String commentText;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Comment() {}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Post getPost(){return post;} public void setPost(Post v){post=v;}
    public User getUser(){return user;} public void setUser(User v){user=v;}
    public String getCommentText(){return commentText;} public void setCommentText(String v){commentText=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
