package com.instagram.service;
import com.instagram.dao.*;
import com.instagram.entity.*;
import java.util.List;
public class MessageService{
 private final ConversationDAO cdao=new ConversationDAO(); private final ConversationUserDAO cudao=new ConversationUserDAO(); private final MessageDAO mdao=new MessageDAO();
 public Conversation create(User a,User b){Conversation c=new Conversation();c=cdao.save(c);ConversationUser x=new ConversationUser();x.setConversation(c);x.setUser(a);cudao.save(x);ConversationUser y=new ConversationUser();y.setConversation(c);y.setUser(b);cudao.save(y);return c;}
 public List<Conversation> conversations(Long u){return cudao.byUser(u);}
 public Message send(Message m){return mdao.save(m);}
 public List<Message> messages(Long c){return mdao.byConversation(c);}
}