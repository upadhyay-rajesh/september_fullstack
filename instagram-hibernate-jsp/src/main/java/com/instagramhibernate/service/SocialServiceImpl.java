package com.instagramhibernate.service; // Declares service package.
import java.util.List; // Imports list support.
import com.instagramhibernate.dao.SocialDAO; // Imports SocialDAO interface.
import com.instagramhibernate.dao.SocialDAOImpl; // Imports its implementation.
import com.instagramhibernate.entity.Comment; // Imports Comment.
import com.instagramhibernate.entity.User; // Imports User.
public class SocialServiceImpl implements SocialService { // Implements social business operations.
    private final SocialDAO socialDAO; // Depends on the DAO interface.
    public SocialServiceImpl() { this.socialDAO = new SocialDAOImpl(); } // Wires the implementation.
    public Comment comment(Long postId, Long userId, String text) { if (text == null || text.trim().length() == 0) { throw new IllegalArgumentException("Comment cannot be empty."); } return socialDAO.addComment(postId, userId, text.trim()); } // Validates and adds comment.
    public void like(Long postId, Long userId) { socialDAO.addLike(postId, userId); } // Delegates like action.
    public void unlike(Long postId, Long userId) { socialDAO.removeLike(postId, userId); } // Delegates unlike action.
    public long likes(Long postId) { return socialDAO.countLikes(postId); } // Delegates like count.
    public void follow(Long followerId, Long followingId) { socialDAO.follow(followerId, followingId); } // Delegates follow.
    public void unfollow(Long followerId, Long followingId) { socialDAO.unfollow(followerId, followingId); } // Delegates unfollow.
    public List<Comment> comments(Long postId) { return socialDAO.commentsForPost(postId); } // Delegates comments query.
    public List<User> followers(Long userId) { return socialDAO.followersOf(userId); } // Delegates followers query.
} // Ends SocialServiceImpl.
