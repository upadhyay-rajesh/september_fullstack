package com.instagramhibernate.controller; // Declares controller package.
import java.io.IOException; // Imports IO exception.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.service.PostService; // Imports service interface.
import com.instagramhibernate.service.PostServiceImpl; // Imports service implementation.
import javax.servlet.ServletException; // Imports servlet exception.
import javax.servlet.annotation.WebServlet; // Imports mapping annotation.
import javax.servlet.http.HttpServlet; // Imports base servlet.
import javax.servlet.http.HttpServletRequest; // Imports request API.
import javax.servlet.http.HttpServletResponse; // Imports response API.
import javax.servlet.http.HttpSession; // Imports session API.
@WebServlet("/posts/create") // Maps post creation form.
public class PostServlet extends HttpServlet { // Creates posts from a normal HTML form.
    private PostService postService; // Stores service interface.
    public void init() { postService = new PostServiceImpl(); } // Initializes service.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { request.getRequestDispatcher("/WEB-INF/views/create-post.jsp").forward(request, response); } // Forwards to create-post JSP.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Handles normal form POST.
        HttpSession session = request.getSession(false); // Gets existing session.
        User user = session == null ? null : (User) session.getAttribute("loggedInUser"); // Reads logged-in user.
        if (user == null) { response.sendRedirect(request.getContextPath() + "/login"); return; } // Requires authentication.
        try { postService.create(user.getId(), request.getParameter("caption"), request.getParameter("imageUrl")); response.sendRedirect(request.getContextPath() + "/home"); } // Creates post then redirects.
        catch (RuntimeException error) { request.setAttribute("error", error.getMessage()); request.getRequestDispatcher("/WEB-INF/views/create-post.jsp").forward(request, response); } // Forwards errors to JSP.
    } // Ends doPost.
} // Ends PostServlet.
