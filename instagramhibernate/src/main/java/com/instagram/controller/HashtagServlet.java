package com.instagram.controller;
import com.instagram.service.HashtagService;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/api/hashtags")
public class HashtagServlet extends JsonServlet{private final HashtagService service=new HashtagService();protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{json(s,service.posts(r.getParameter("name")));}}
