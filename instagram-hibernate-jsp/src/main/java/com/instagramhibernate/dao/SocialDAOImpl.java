package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Imports list support.
import org.hibernate.Session; // Imports Hibernate Session.
import org.hibernate.Transaction; // Imports transaction support.
import org.hibernate.query.Query; // Imports HQL Query.
import com.instagramhibernate.entity.Comment; // Imports Comment entity.
import com.instagramhibernate.entity.Follower; // Imports Follower entity.
import com.instagramhibernate.entity.Like; // Imports Like entity.
import com.instagramhibernate.entity.Post; // Imports Post entity.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.util.HibernateUtil; // Imports SessionFactory utility.
public class SocialDAOImpl implements SocialDAO { // Implements social actions.
    public Comment addComment(Long postId, Long userId, String text) { // Creates a comment inside a transaction.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction tx = null; // Prepares transaction variable.
        try { tx = session.beginTransaction(); Post post = session.get(Post.class, postId); User user = session.get(User.class, userId); if (post == null || user == null) { throw new IllegalArgumentException("Post or user not found"); } Comment comment = new Comment(); comment.setPost(post); comment.setUser(user); comment.setCommentText(text); session.save(comment); tx.commit(); return comment; } // Validates references and saves comment.
        catch (RuntimeException e) { if (tx != null) { tx.rollback(); } throw e; } // Rolls back if saving fails.
        finally { session.close(); } // Closes the session.
    } // Ends addComment.
    public void addLike(Long postId, Long userId) { // Adds a like if it does not already exist.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction tx = null; // Prepares transaction variable.
        try { tx = session.beginTransaction(); Query<Long> q = session.createQuery("select count(l) from Like l where l.post.id = :postId and l.user.id = :userId", Long.class); q.setParameter("postId", postId); q.setParameter("userId", userId); if (q.uniqueResult().longValue() == 0L) { Like like = new Like(); like.setPost(session.get(Post.class, postId)); like.setUser(session.get(User.class, userId)); session.save(like); } tx.commit(); } // Checks duplicates then saves.
        catch (RuntimeException e) { if (tx != null) { tx.rollback(); } throw e; } // Rolls back failures.
        finally { session.close(); } // Closes the session.
    } // Ends addLike.
    public void removeLike(Long postId, Long userId) { // Removes a like using HQL delete.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction tx = null; // Prepares transaction variable.
        try { tx = session.beginTransaction(); Query<?> q = session.createQuery("delete from Like l where l.post.id = :postId and l.user.id = :userId"); q.setParameter("postId", postId); q.setParameter("userId", userId); q.executeUpdate(); tx.commit(); } // Executes bulk delete and commits.
        catch (RuntimeException e) { if (tx != null) { tx.rollback(); } throw e; } // Rolls back failures.
        finally { session.close(); } // Closes the session.
    } // Ends removeLike.
    public long countLikes(Long postId) { // Counts likes for a post.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<Long> q = session.createQuery("select count(l) from Like l where l.post.id = :postId", Long.class); q.setParameter("postId", postId); return q.uniqueResult().longValue(); } // Returns the aggregate count.
        finally { session.close(); } // Closes the session.
    } // Ends countLikes.
    public void follow(Long followerId, Long followingId) { // Creates a follow relationship.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction tx = null; // Prepares transaction variable.
        try { tx = session.beginTransaction(); if (!followerId.equals(followingId)) { Query<Long> q = session.createQuery("select count(f) from Follower f where f.follower.id = :a and f.following.id = :b", Long.class); q.setParameter("a", followerId); q.setParameter("b", followingId); if (q.uniqueResult().longValue() == 0L) { Follower f = new Follower(); f.setFollower(session.get(User.class, followerId)); f.setFollowing(session.get(User.class, followingId)); session.save(f); } } tx.commit(); } // Prevents self-follow and duplicate rows.
        catch (RuntimeException e) { if (tx != null) { tx.rollback(); } throw e; } // Rolls back failures.
        finally { session.close(); } // Closes the session.
    } // Ends follow.
    public void unfollow(Long followerId, Long followingId) { // Removes a follow relationship.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction tx = null; // Prepares transaction variable.
        try { tx = session.beginTransaction(); Query<?> q = session.createQuery("delete from Follower f where f.follower.id = :a and f.following.id = :b"); q.setParameter("a", followerId); q.setParameter("b", followingId); q.executeUpdate(); tx.commit(); } // Executes parameterized delete.
        catch (RuntimeException e) { if (tx != null) { tx.rollback(); } throw e; } // Rolls back failures.
        finally { session.close(); } // Closes the session.
    } // Ends unfollow.
    public List<Comment> commentsForPost(Long postId) { // Reads comments with their authors.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<Comment> q = session.createQuery("select c from Comment c join fetch c.user where c.post.id = :postId order by c.createdAt asc", Comment.class); q.setParameter("postId", postId); return q.getResultList(); } // Executes ordered comment query.
        finally { session.close(); } // Closes the session.
    } // Ends commentsForPost.
    public List<User> followersOf(Long userId) { // Reads users following the given user.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<User> q = session.createQuery("select f.follower from Follower f where f.following.id = :userId", User.class); q.setParameter("userId", userId); return q.getResultList(); } // Selects follower entities.
        finally { session.close(); } // Closes the session.
    } // Ends followersOf.
} // Ends SocialDAOImpl.
