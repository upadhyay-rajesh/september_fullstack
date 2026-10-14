package com.instagram.dao;
import com.instagram.entity.Message;
import java.util.List;
public class MessageDAO extends BaseDAO<Message>{
 public MessageDAO(){super(Message.class);}
 public List<Message> byConversation(Long c){return tx(s->s.createQuery("from Message m join fetch m.sender where m.conversation.id=:c order by m.sentAt asc",Message.class).setParameter("c",c).getResultList());}
}