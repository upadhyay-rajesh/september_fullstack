package com.instagramhibernate.controller; // Declares controller package.
import java.io.IOException; // Imports IO exception.
import javax.servlet.annotation.WebServlet; // Imports servlet mapping.
import javax.servlet.http.HttpServlet; // Imports base servlet.
import javax.servlet.http.HttpServletRequest; // Imports request API.
import javax.servlet.http.HttpServletResponse; // Imports response API.
@WebServlet("/logout") // Maps logout URL.
public class LogoutServlet extends HttpServlet { // Handles logout.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException { request.getSession().invalidate(); response.sendRedirect(request.getContextPath() + "/login"); } // Invalidates session and redirects to login.
} // Ends LogoutServlet.
