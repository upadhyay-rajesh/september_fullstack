package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/conversations")
public class ConversationServlet extends JsonServlet{
 private final MessageService service=new MessageService();private final UserService users=new UserService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;json(s,service.conversations(sessionUser(r)));}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Conversation c=service.create(users.findById(sessionUser(r)),users.findById(Long.valueOf(r.getParameter("userId"))));json(s,Map.of("success",true,"id",c.getId()));}
}