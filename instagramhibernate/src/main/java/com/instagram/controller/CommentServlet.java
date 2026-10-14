package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/comments")
public class CommentServlet extends JsonServlet{
 private final CommentService service=new CommentService();private final PostService posts=new PostService();private final UserService users=new UserService();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{json(s,service.byPost(Long.valueOf(r.getParameter("postId"))));}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Comment c=new Comment();c.setPost(posts.find(Long.valueOf(r.getParameter("postId"))));c.setUser(users.findById(sessionUser(r)));c.setCommentText(r.getParameter("text"));service.save(c);json(s,Map.of("success",true,"id",c.getId()));}
 protected void doDelete(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Comment c=service.find(Long.valueOf(r.getParameter("id")));if(c!=null&&c.getUser().getId().equals(sessionUser(r)))service.delete(c);json(s,Map.of("success",true));}
}