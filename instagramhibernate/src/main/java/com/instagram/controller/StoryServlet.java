package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.time.LocalDateTime; import java.util.*;
@WebServlet("/api/stories")
public class StoryServlet extends JsonServlet{
 private final StoryService service=new StoryService();private final UserService users=new UserService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{json(s,service.active());}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Story st=new Story();st.setUser(users.findById(sessionUser(r)));st.setMediaUrl(r.getParameter("mediaUrl"));st.setExpiresAt(LocalDateTime.now().plusHours(24));service.save(st);json(s,Map.of("success",true,"id",st.getId()));}
}