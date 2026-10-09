package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.State;

public class LoadCaptchaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		long ll = (long)((Math.random())*10000);
		String p = ll+"hello";
		System.out.println(ll);
		
		out.println("<html><body>");
		
			out.println("<input type=text disabled value="+p+">");
			out.println("<input type=hidden id=cvalue value="+p+">");
			out.println("<input type=button value=refresh onClick=loadCaptcha()>");
			out.println("enter capcha value <input type=text id=evalue onblur=validateCaptcha()>");
				
				
			
				
		
			out.println("</body></html>");
	}

}
