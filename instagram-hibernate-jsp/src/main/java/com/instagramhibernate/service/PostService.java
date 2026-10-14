package com.instagramhibernate.service; // Declares service package.
import java.util.List; // Imports list support.
import com.instagramhibernate.entity.Post; // Imports Post entity.
public interface PostService { // Defines post business operations.
    Post create(Long userId, String caption, String imageUrl); // Creates a post.
    List<Post> latest(); // Reads latest posts.
    List<Post> feed(Long userId); // Reads the personalized feed.
    List<Post> byUser(Long userId); // Reads posts from one user.
    List<Post> search(String keyword); // Searches captions.
} // Ends PostService.
