package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.*;
@WebServlet("/api/saved")
public class SavePostServlet extends JsonServlet{
 private final SavedPostService service=new SavedPostService();private final PostService posts=new PostService();private final UserService users=new UserService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;json(s,service.byUser(sessionUser(r)));}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;SavedPost x=new SavedPost();x.setUser(users.findById(sessionUser(r)));x.setPost(posts.find(Long.valueOf(r.getParameter("postId"))));json(s,Map.of("saved",service.toggle(x)));}
}