package com.instagramhibernate.service; // Declares service package.
import java.util.List; // Imports list support.
import com.instagramhibernate.dao.UserDAO; // Imports the DAO interface.
import com.instagramhibernate.dao.UserDAOImpl; // Imports the Hibernate DAO implementation.
import com.instagramhibernate.entity.User; // Imports User entity.
public class UserServiceImpl implements UserService { // Implements user business rules.
    private final UserDAO userDAO; // Depends on the DAO interface.
    public UserServiceImpl() { this.userDAO = new UserDAOImpl(); } // Wires the DAO implementation.
    public User register(User user) { // Validates then persists a user.
        if (user == null || blank(user.getUsername()) || blank(user.getEmail()) || blank(user.getPassword())) { throw new IllegalArgumentException("Username, email and password are required."); } // Rejects missing fields.
        if (userDAO.findByUsername(user.getUsername()) != null) { throw new IllegalArgumentException("Username already exists."); } // Prevents duplicate usernames.
        return userDAO.save(user); // Delegates persistence to the DAO.
    } // Ends register.
    public User login(String username, String password) { // Delegates credential lookup.
        if (blank(username) || blank(password)) { return null; } // Rejects empty credentials.
        return userDAO.authenticate(username, password); // Executes the DAO authentication query.
    } // Ends login.
    public User findById(Long id) { return userDAO.findById(id); } // Delegates id lookup.
    public List<User> search(String keyword) { return userDAO.searchUsers(keyword == null ? "" : keyword); } // Delegates search.
    private boolean blank(String value) { return value == null || value.trim().length() == 0; } // Tests null or whitespace strings.
} // Ends UserServiceImpl.
