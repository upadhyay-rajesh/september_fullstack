package com.instagram.controller;
import com.instagram.entity.User; import com.instagram.service.UserService;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.*;
@WebServlet("/api/users")
public class UserServlet extends JsonServlet{
 private final UserService service=new UserService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{
  String q=r.getParameter("q"); if(q!=null){json(s,service.search(q));return;}
  Long id=Long.valueOf(r.getParameter("id"));User u=service.findById(id);
  if(u==null){s.setStatus(404);json(s,Map.of("message","User not found"));return;}json(s,Map.of("id",u.getId(),"username",u.getUsername(),"fullName",u.getFullName(),"bio",u.getBio()));
 }
}