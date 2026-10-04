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

public class ViewProfileServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession(true);
		String email = ss.getAttribute("myuserid").toString();//session.getAttribute always return object so using toString() method we can convert object into string
	
		
		FacebookUser fb = new FacebookUser();
		fb.setEmail(email);
		
		FacebookServicInterface fs = new FacebookService();
		 FacebookUser f1 =  fs.viewProfileService(fb);
		 
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			
			out.println("<html><body>");
			if(f1 !=null) {
				out.println("Your Details are ");
				out.println("<br> Name is "+f1.getName());
				out.println("<br> Password is "+f1.getPassword());
				out.println("<br> Email is "+f1.getEmail());
				out.println("<br> ADDRESS is "+f1.getAddress());
			}
			out.println("</body></html>");
		
	}

}










