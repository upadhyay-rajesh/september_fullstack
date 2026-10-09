package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServicInterface;
import com.facebookweb.service.FacebookService;


public class EditProfileServlet1 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("n");
		String password = request.getParameter("p");
		String email = request.getParameter("e");
		String address = request.getParameter("a");
		
		FacebookUser fb = new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		FacebookServicInterface fs = new FacebookService();
		int i=fs.editProfileService(fb);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		if(i>0) {
			out.println("Your profile edited <br>");
			FacebookUser fb1 = new FacebookUser();
			fb1.setEmail(email);
			
			FacebookServicInterface fs1 = new FacebookService();
			 FacebookUser f1 =  fs1.viewProfileService(fb1);
			 out.println("Your updated Details are ");
				out.println("<br> Name is "+f1.getName());
				out.println("<br> Password is "+f1.getPassword());
				out.println("<br> Email is "+f1.getEmail());
				out.println("<br> ADDRESS is "+f1.getAddress());
			
		}
		out.println("</center></body></html>");
	}

}
