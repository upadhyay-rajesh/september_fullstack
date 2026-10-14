package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Imports list support.
import com.instagramhibernate.entity.Comment; // Imports Comment.
import com.instagramhibernate.entity.User; // Imports User.
public interface SocialDAO { // Defines social-action persistence operations.
    Comment addComment(Long postId, Long userId, String text); // Adds a comment.
    void addLike(Long postId, Long userId); // Likes a post.
    void removeLike(Long postId, Long userId); // Removes a like.
    long countLikes(Long postId); // Counts likes.
    void follow(Long followerId, Long followingId); // Creates a follow relationship.
    void unfollow(Long followerId, Long followingId); // Removes a follow relationship.
    List<Comment> commentsForPost(Long postId); // Reads comments for one post.
    List<User> followersOf(Long userId); // Reads followers for one user.
} // Ends SocialDAO.
