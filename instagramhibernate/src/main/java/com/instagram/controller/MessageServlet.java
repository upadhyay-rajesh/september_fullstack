package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/messages")
public class MessageServlet extends JsonServlet{
 private final MessageService service=new MessageService();private final UserService users=new UserService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;json(s,service.messages(Long.valueOf(r.getParameter("conversationId"))));}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Message m=new Message();m.setSender(users.findById(sessionUser(r)));Conversation c=new Conversation();c.setId(Long.valueOf(r.getParameter("conversationId")));m.setConversation(c);m.setMessageText(r.getParameter("text"));service.send(m);json(s,Map.of("success",true,"id",m.getId()));}
}