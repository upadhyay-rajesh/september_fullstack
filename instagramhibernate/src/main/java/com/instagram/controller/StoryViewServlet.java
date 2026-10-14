package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/story-views")
public class StoryViewServlet extends JsonServlet{
 private final StoryService service=new StoryService();private final UserService users=new UserService();
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Story st=service.active().stream().filter(x->x.getId().equals(Long.valueOf(r.getParameter("storyId")))).findFirst().orElse(null);if(st==null){s.setStatus(404);json(s,Map.of("message","Story not found"));return;}StoryView v=new StoryView();v.setStory(st);v.setUser(users.findById(sessionUser(r)));boolean added=service.view(v);json(s,Map.of("added",added,"views",service.views(st.getId())));}
}