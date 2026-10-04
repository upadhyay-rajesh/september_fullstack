package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServicInterface;
import com.facebookweb.service.FacebookService;

public class SearchProfileServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession(true);
		String email = ss.getAttribute("myuserid").toString();//session.getAttribute always return object so using toString() method we can convert object into string
		FacebookUser fb = new FacebookUser();
		fb.setEmail(email);
		
		FacebookServicInterface fs = new FacebookService();
		 List<FacebookUser> ll =  fs.searchProfileService();
		 
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			out.println("</body></html>");
	}

}
