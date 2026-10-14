package com.instagramhibernate.controller; // Declares controller package.
import java.io.IOException; // Imports IO exception.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.service.PostService; // Imports post service interface.
import com.instagramhibernate.service.PostServiceImpl; // Imports service implementation.
import javax.servlet.ServletException; // Imports servlet exception.
import javax.servlet.annotation.WebServlet; // Imports servlet mapping.
import javax.servlet.http.HttpServlet; // Imports base servlet.
import javax.servlet.http.HttpServletRequest; // Imports request API.
import javax.servlet.http.HttpServletResponse; // Imports response API.
import javax.servlet.http.HttpSession; // Imports session API.
@WebServlet("/home") // Maps the home page controller.
public class HomeServlet extends HttpServlet { // Loads posts and forwards them to JSP.
    private PostService postService; // Stores service interface.
    public void init() { postService = new PostServiceImpl(); } // Initializes service.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Handles home requests.
        HttpSession session = request.getSession(false); // Reads an existing login session.
        User user = session == null ? null : (User) session.getAttribute("loggedInUser"); // Reads authenticated user safely.
        if (user == null) { response.sendRedirect(request.getContextPath() + "/login"); return; } // Requires login.
        request.setAttribute("posts", postService.feed(user.getId())); // Adds feed list to request scope.
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response); // Forwards request and data to JSP.
    } // Ends doGet.
} // Ends HomeServlet.
