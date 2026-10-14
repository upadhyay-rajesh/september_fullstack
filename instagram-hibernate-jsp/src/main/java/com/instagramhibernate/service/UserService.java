package com.instagramhibernate.service; // Declares service package.
import java.util.List; // Imports list support.
import com.instagramhibernate.entity.User; // Imports User entity.
public interface UserService { // Defines the user business contract consumed by servlets.
    User register(User user); // Registers a new user.
    User login(String username, String password); // Authenticates a user.
    User findById(Long id); // Finds user by id.
    List<User> search(String keyword); // Searches users.
} // Ends UserService.
