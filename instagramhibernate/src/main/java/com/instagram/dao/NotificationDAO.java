package com.instagram.dao;
import com.instagram.entity.Notification;
import java.util.List;
public class NotificationDAO extends BaseDAO<Notification>{
 public NotificationDAO(){super(Notification.class);}
 public List<Notification> unread(Long u){return tx(s->s.createQuery("from Notification n join fetch n.actor where n.user.id=:u and n.isRead=false order by n.createdAt desc",Notification.class).setParameter("u",u).getResultList());}
 public void markRead(Long id){tx(s->{s.createMutationQuery("update Notification n set n.isRead=true where n.id=:id").setParameter("id",id).executeUpdate();return null;});}
}