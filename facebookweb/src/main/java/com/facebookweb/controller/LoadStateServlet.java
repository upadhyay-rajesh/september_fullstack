package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.State;
import com.facebookweb.service.FacebookServicInterface;
import com.facebookweb.service.FacebookService;

public class LoadStateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("cid");
		Country c=new Country();
		c.setCountryName(cname);
		
		FacebookServicInterface fs = new FacebookService();
		List<State> b = fs.loadStateService(c);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<select class=form-control w-25 id=state name=state onChange=loadCity()>");
			for(State c1:b) {
				
				out.println("<option>"+c1.getStateName()+"</option>");
			}
				
			out.println("</select>");
			out.println("</body></html>");
	}

}
