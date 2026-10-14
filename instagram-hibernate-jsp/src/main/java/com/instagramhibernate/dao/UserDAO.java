package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Imports list results.
import com.instagramhibernate.entity.User; // Imports the User entity.
public interface UserDAO extends GenericDAO<User> { // Defines user-specific persistence operations.
    User findByUsername(String username); // Finds a user by username.
    User authenticate(String username, String password); // Checks supplied login credentials.
    List<User> searchUsers(String keyword); // Searches usernames and full names.
} // Ends UserDAO.
