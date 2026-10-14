package com.instagram.controller;
import com.instagram.entity.User; import com.instagram.service.UserService;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/login")
public class LoginServlet extends JsonServlet{
 private final UserService service=new UserService();
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{
  User u=service.login(r.getParameter("username"),r.getParameter("password"));
  if(u==null){s.setStatus(401);json(s,Map.of("success",false,"message","Invalid credentials"));return;}
  r.getSession().setAttribute("userId",u.getId());r.getSession().setAttribute("username",u.getUsername());
  json(s,Map.of("success",true,"userId",u.getId(),"username",u.getUsername()));
 }
}