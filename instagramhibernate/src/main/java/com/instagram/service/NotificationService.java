package com.instagram.service;
import com.instagram.dao.NotificationDAO;
import com.instagram.entity.Notification;
import java.util.List;
public class NotificationService{
 private final NotificationDAO dao=new NotificationDAO();
 public Notification save(Notification n){return dao.save(n);}
 public List<Notification> unread(Long u){return dao.unread(u);}
 public void markRead(Long id){dao.markRead(id);}
}