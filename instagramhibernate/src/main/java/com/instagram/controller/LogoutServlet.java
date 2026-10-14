package com.instagram.controller;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.util.Map;
@WebServlet("/api/logout")
public class LogoutServlet extends JsonServlet{protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{r.getSession().invalidate();json(s,Map.of("success",true));}}
