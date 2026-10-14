package com.instagramhibernate.controller; // Declares controller package.

import java.io.IOException; // Imports IO exception.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.service.UserService; // Imports service interface.
import com.instagramhibernate.service.UserServiceImpl; // Imports service implementation.
import javax.servlet.ServletException; // Imports servlet exception.
import javax.servlet.annotation.WebServlet; // Imports servlet mapping.
import javax.servlet.http.HttpServlet; // Imports base servlet.
import javax.servlet.http.HttpServletRequest; // Imports request API.
import javax.servlet.http.HttpServletResponse; // Imports response API.
import javax.servlet.http.HttpSession; // Imports session API.

@WebServlet("/login") // Maps login URL.
public class LoginServlet extends HttpServlet { // Handles login forms.
	private UserService userService; // Stores service interface.

	public void init() {
		userService = new UserServiceImpl();
	} // Creates service object.

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	} // Forwards to login JSP.

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // Handles login submission.
		User user = userService.login(request.getParameter("username"), request.getParameter("password")); // Authenticates
																											// through
																											// service.
		if (user == null) {
			request.setAttribute("error", "Invalid username or password.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return;
		} // Forwards an error if authentication fails.
		HttpSession session = request.getSession(true); // Creates or obtains the HTTP session.
		session.setAttribute("loggedInUser", user); // Stores authenticated user in session.
		response.sendRedirect(request.getContextPath() + "/home"); // Redirects to the home controller.
	} // Ends doPost.
} // Ends LoginServlet.
