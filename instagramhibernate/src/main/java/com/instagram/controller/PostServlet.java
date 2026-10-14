package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.*;
@WebServlet("/api/posts")
public class PostServlet extends JsonServlet{
 private final PostService service=new PostService(); private final UserService users=new UserService(); private final HashtagService hashtags=new HashtagService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{
  Long uid=sessionUser(r); if(uid==null){s.setStatus(401);json(s,Map.of("message","Login required"));return;}
  String q=r.getParameter("q"); if(q!=null){json(s,service.search(q));return;}
  int page=Integer.parseInt(Optional.ofNullable(r.getParameter("page")).orElse("0")); int size=Integer.parseInt(Optional.ofNullable(r.getParameter("size")).orElse("10"));
  json(s,service.feed(uid,page,size));
 }
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{
  if(!requireLogin(s,r))return; User u=users.findById(sessionUser(r));Post p=new Post();p.setUser(u);p.setCaption(r.getParameter("caption"));p.setImageUrl(r.getParameter("imageUrl"));service.save(p);hashtags.addToPost(p,p.getCaption());json(s,Map.of("success",true,"id",p.getId()));
 }
 protected void doDelete(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Post p=service.find(Long.valueOf(r.getParameter("id")));if(p!=null&&p.getUser().getId().equals(sessionUser(r)))service.delete(p);json(s,Map.of("success",true));}
}