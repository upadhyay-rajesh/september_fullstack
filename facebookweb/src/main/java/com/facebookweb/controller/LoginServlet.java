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

public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("ee");
		String password = request.getParameter("pass");
		
		FacebookUser fb = new FacebookUser();
		fb.setEmail(email);
		fb.setPassword(password);
		
		FacebookServicInterface fs = new FacebookService();
		boolean b = fs.loginProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
			if(b) {
				//how to create session
				HttpSession ss =request.getSession(true);//this line will create session whichwill be valid for 30 minutes by default
				//how to store data i.e. userid in session?
				ss.setAttribute("myuserid", email);
				
				//ss.setMaxInactiveInterval(5); //this will set session time for 5 minutes
				
				out.println("Welcome "+email);
				out.println("<br><a href=ViewProfileServlet>view profile</a>");
				out.println("<br><a href=EditProfileServlet>edit profile</a>");
				out.println("<br><a href=ViewAllProfileServlet>view all profile</a>");
				out.println("<br><a href=DeleteProfileServlet>delete profile</a>");
				out.println("<br><a href=SearchProfileServlet>serach profile</a>");
				out.println("<br><a href=LogoutProfileServlet>Log Out</a>");
			}
			else {
				out.println("Invalid id and password <br><a href=login.html>Try Again</a>");
			}
			out.println("</body></html>");
	}

}
