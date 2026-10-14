package com.instagram.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import java.io.IOException;
public abstract class JsonServlet extends HttpServlet{
 protected final ObjectMapper mapper=new ObjectMapper();
 protected void json(HttpServletResponse r,Object value)throws IOException{
   r.setContentType("application/json"); r.setCharacterEncoding("UTF-8"); mapper.writeValue(r.getWriter(),value);
 }
 protected Long sessionUser(HttpServletRequest r){Object x=r.getSession().getAttribute("userId");return x==null?null:((Number)x).longValue();}
 protected boolean requireLogin(HttpServletResponse r,HttpServletRequest q)throws IOException{if(sessionUser(q)==null){r.setStatus(401);json(r,java.util.Map.of("success",false,"message","Login required"));return false;}return true;}
}
