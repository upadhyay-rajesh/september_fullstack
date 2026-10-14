package com.instagram.dao;
import com.instagram.entity.ConversationUser;
import com.instagram.entity.Conversation;
import java.util.List;
public class ConversationUserDAO extends BaseDAO<ConversationUser>{
 public ConversationUserDAO(){super(ConversationUser.class);}
 public List<Conversation> byUser(Long u){return tx(s->s.createQuery("select x.conversation from ConversationUser x where x.user.id=:u",Conversation.class).setParameter("u",u).getResultList());}
}