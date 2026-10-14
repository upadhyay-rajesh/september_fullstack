package com.instagram.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;

import com.instagram.entity.User;
import com.instagram.service.UserService;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private final UserService service = new UserService();

	protected void doPost(HttpServletRequest r, HttpServletResponse s) throws IOException {
		try {
			User u = new User();
			u.setUsername(r.getParameter("username"));
			u.setEmail(r.getParameter("email"));
			u.setPassword(r.getParameter("password"));
			u.setFullName(r.getParameter("fullName"));
			service.register(u);
			//json(s, Map.of("success", true, "message", "Registered"));
			
			r.setAttribute("result", "Profile Created");
			
			RequestDispatcher rd=   getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(r, s);
			
		} catch (Exception e) {
			s.setStatus(400);
			
		}
	}
}