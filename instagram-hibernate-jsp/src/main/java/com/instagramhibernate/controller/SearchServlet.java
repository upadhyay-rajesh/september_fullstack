package com.instagramhibernate.controller; // Declares controller package.
import java.io.IOException; // Imports IO exception.
import com.instagramhibernate.service.PostService; // Imports PostService interface.
import com.instagramhibernate.service.PostServiceImpl; // Imports service implementation.
import com.instagramhibernate.service.UserService; // Imports UserService interface.
import com.instagramhibernate.service.UserServiceImpl; // Imports service implementation.
import javax.servlet.ServletException; // Imports servlet exception.
import javax.servlet.annotation.WebServlet; // Imports mapping.
import javax.servlet.http.HttpServlet; // Imports base servlet.
import javax.servlet.http.HttpServletRequest; // Imports request API.
import javax.servlet.http.HttpServletResponse; // Imports response API.
@WebServlet("/search") // Maps search URL.
public class SearchServlet extends HttpServlet { // Searches users and captions.
    private UserService userService; // Stores user service interface.
    private PostService postService; // Stores post service interface.
    public void init() { userService = new UserServiceImpl(); postService = new PostServiceImpl(); } // Initializes services.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Handles search form and results.
        String keyword = request.getParameter("q"); // Reads the query string from the normal HTML form.
        request.setAttribute("keyword", keyword == null ? "" : keyword); // Makes the keyword available to JSP.
        request.setAttribute("users", userService.search(keyword)); // Adds user search results.
        request.setAttribute("posts", postService.search(keyword)); // Adds post search results.
        request.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(request, response); // Forwards result data to JSP.
    } // Ends doGet.
} // Ends SearchServlet.
