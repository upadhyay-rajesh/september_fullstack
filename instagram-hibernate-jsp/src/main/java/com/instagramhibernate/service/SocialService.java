package com.instagramhibernate.service; // Declares service package.
import java.util.List; // Imports list support.
import com.instagramhibernate.entity.Comment; // Imports Comment entity.
import com.instagramhibernate.entity.User; // Imports User entity.
public interface SocialService { // Defines social business operations.
    Comment comment(Long postId, Long userId, String text); // Adds a comment.
    void like(Long postId, Long userId); // Likes a post.
    void unlike(Long postId, Long userId); // Removes a like.
    long likes(Long postId); // Counts likes.
    void follow(Long followerId, Long followingId); // Follows another user.
    void unfollow(Long followerId, Long followingId); // Unfollows another user.
    List<Comment> comments(Long postId); // Lists comments.
    List<User> followers(Long userId); // Lists followers.
} // Ends SocialService.
