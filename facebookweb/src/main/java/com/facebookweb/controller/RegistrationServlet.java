package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServicInterface;
import com.facebookweb.service.FacebookService;

public class RegistrationServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("n");
		String password = request.getParameter("pass");
		String email = request.getParameter("ee");
		String address = request.getParameter("aa");
		
		FacebookUser fb = new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		FacebookServicInterface fs = new FacebookService();
		int i=fs.createProfileService(fb);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		if(i>0) {
			out.println("Your Registration complete <br>");
			out.println("<a href=login.html>click here to login</a> ");
			
		}
		out.println("</center></body></html>");
	}

}
