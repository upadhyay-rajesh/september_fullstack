package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.Country;
import com.facebookweb.service.FacebookServicInterface;
import com.facebookweb.service.FacebookService;


public class LoadCountryServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacebookServicInterface fs = new FacebookService();
		List<Country> b = fs.loadCountryService();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<select class=form-control w-25 id=country name=country onChange=loadState()>");
			for(Country c:b) {
				
				out.println("<option>"+c.getCountryName()+"</option>");
			}
				
			out.println("</select>");
			out.println("</body></html>");
	}

}
