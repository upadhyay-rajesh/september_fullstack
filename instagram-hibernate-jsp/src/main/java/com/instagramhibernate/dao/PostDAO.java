package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Imports list results.
import com.instagramhibernate.entity.Post; // Imports the Post entity.
public interface PostDAO extends GenericDAO<Post> { // Defines post-specific persistence operations.
    List<Post> latestPosts(); // Reads recent posts with author information.
    List<Post> postsByUser(Long userId); // Reads posts created by a user.
    List<Post> feedForUser(Long userId); // Reads current user's posts and followed users' posts.
    List<Post> searchCaptions(String keyword); // Searches post captions.
} // Ends PostDAO.
