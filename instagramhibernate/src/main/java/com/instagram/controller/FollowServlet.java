package com.instagram.controller;
import com.instagram.entity.*; import com.instagram.service.*;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/follows")
public class FollowServlet extends JsonServlet{
 private final FollowerService service=new FollowerService();private final UserService users=new UserService();
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{if(!requireLogin(s,r))return;Follower f=new Follower();f.setFollower(users.findById(sessionUser(r)));f.setFollowing(users.findById(Long.valueOf(r.getParameter("userId"))));boolean following=service.toggle(f);json(s,Map.of("following",following,"followers",service.followersCount(f.getFollowing().getId())));}
}