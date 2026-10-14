package com.instagram.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="conversations")
public class Conversation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private LocalDateTime createdAt=LocalDateTime.now();
    public Conversation(){}
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
