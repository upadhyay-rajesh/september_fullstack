package com.instagram.controller;
import com.instagram.service.NotificationService;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/notifications")
public class NotificationServlet extends JsonServlet{
 private final NotificationService service=new NotificationService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;json(s,service.unread(sessionUser(r)));}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;service.markRead(Long.valueOf(r.getParameter("id")));json(s,Map.of("success",true));}
}