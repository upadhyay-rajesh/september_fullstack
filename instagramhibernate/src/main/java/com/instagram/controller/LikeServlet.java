package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/likes")
public class LikeServlet extends JsonServlet{
 private final LikeService service=new LikeService();private final PostService posts=new PostService();private final UserService users=new UserService();
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;PostLike l=new PostLike();l.setPost(posts.find(Long.valueOf(r.getParameter("postId"))));l.setUser(users.findById(sessionUser(r)));boolean liked=service.toggle(l);json(s,Map.of("liked",liked,"count",service.count(l.getPost().getId())));}
}