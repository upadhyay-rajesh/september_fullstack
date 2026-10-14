package com.instagramhibernate.service; // Declares service package.
import java.time.LocalDateTime; // Imports timestamp support.
import java.util.List; // Imports list support.
import org.hibernate.Session; // Imports Session for transactional entity association lookup.
import org.hibernate.Transaction; // Imports transaction support.
import com.instagramhibernate.dao.PostDAO; // Imports PostDAO interface.
import com.instagramhibernate.dao.PostDAOImpl; // Imports PostDAO implementation.
import com.instagramhibernate.entity.Post; // Imports Post entity.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.util.HibernateUtil; // Imports SessionFactory utility.
public class PostServiceImpl implements PostService { // Implements post business operations.
    private final PostDAO postDAO; // Holds the DAO interface.
    public PostServiceImpl() { this.postDAO = new PostDAOImpl(); } // Creates the DAO implementation.
    public Post create(Long userId, String caption, String imageUrl) { // Creates and persists a post.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session for author lookup.
        Transaction tx = null; // Tracks transaction state.
        try { tx = session.beginTransaction(); User user = session.get(User.class, userId); if (user == null) { throw new IllegalArgumentException("User not found."); } Post post = new Post(); post.setUser(user); post.setCaption(caption); post.setImageUrl(imageUrl); post.setCreatedAt(LocalDateTime.now()); session.save(post); tx.commit(); return post; } // Associates the user and saves.
        catch (RuntimeException e) { if (tx != null) { tx.rollback(); } throw e; } // Rolls back errors.
        finally { session.close(); } // Closes session.
    } // Ends create.
    public List<Post> latest() { return postDAO.latestPosts(); } // Delegates latest-post query.
    public List<Post> feed(Long userId) { return postDAO.feedForUser(userId); } // Delegates feed query.
    public List<Post> byUser(Long userId) { return postDAO.postsByUser(userId); } // Delegates user-post query.
    public List<Post> search(String keyword) { return postDAO.searchCaptions(keyword == null ? "" : keyword); } // Delegates caption search.
} // Ends PostServiceImpl.
