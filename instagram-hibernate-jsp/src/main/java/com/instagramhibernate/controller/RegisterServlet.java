package com.instagramhibernate.controller; // Declares controller package.

import java.io.IOException; // Imports servlet IO exception.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.service.UserService; // Imports service interface.
import com.instagramhibernate.service.UserServiceImpl; // Imports service implementation.
import javax.servlet.ServletException; // Imports ServletException.
import javax.servlet.annotation.WebServlet; // Imports servlet mapping annotation.
import javax.servlet.http.HttpServlet; // Imports base servlet.
import javax.servlet.http.HttpServletRequest; // Imports request API.
import javax.servlet.http.HttpServletResponse; // Imports response API.

@WebServlet("/register") // Maps this controller to /register.
public class RegisterServlet extends HttpServlet { // Handles registration form submissions.
	private UserService userService; // Stores service through its interface.

	public void init() {
		userService = new UserServiceImpl();
	} // Initializes service once.


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // Handles submitted registration form.
		User user = new User(); // Creates a user entity from form fields.
		user.setUsername(request.getParameter("username")); // Reads username from request.
		user.setEmail(request.getParameter("email")); // Reads email from request.
		user.setPassword(request.getParameter("password")); // Reads password for this educational sample.
		user.setFullName(request.getParameter("fullName")); // Reads full name from request.
		try {
			userService.register(user);
			request.setAttribute("message", "Registration successful. Please log in.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		} // Registers and forwards a result attribute to JSP.
		catch (RuntimeException error) {
			request.setAttribute("error", error.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
		} // Forwards validation/database errors to JSP.
	} // Ends doPost.
} // Ends RegisterServlet.
