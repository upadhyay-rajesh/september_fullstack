package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServicInterface;
import com.facebookweb.service.FacebookService;

public class EmailValidatorServlet extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("e1");
	
	
	FacebookUser fb = new FacebookUser();
	fb.setEmail(email);
	
	
	FacebookServicInterface fs = new FacebookService();
	boolean b = fs.checkEmailService(fb);
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<html><body>");
		if(b) {
			
			out.println("email already exist choose another email");
			
		}
		else {
			out.println("valid email");
		}
		out.println("</body></html>");
	}

}
