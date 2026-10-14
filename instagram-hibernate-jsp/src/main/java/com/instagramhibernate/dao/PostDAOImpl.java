package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Imports list support.
import org.hibernate.Session; // Imports Hibernate Session.
import org.hibernate.query.Query; // Imports HQL Query.
import com.instagramhibernate.entity.Post; // Imports Post entity.
import com.instagramhibernate.util.HibernateUtil; // Imports SessionFactory utility.
public class PostDAOImpl extends AbstractHibernateDAO<Post> implements PostDAO { // Implements post queries.
    public PostDAOImpl() { super(Post.class); } // Configures the generic DAO for Post.
    public List<Post> latestPosts() { // Reads newest posts first.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<Post> query = session.createQuery("select p from Post p join fetch p.user order by p.createdAt desc", Post.class); query.setMaxResults(50); return query.getResultList(); } // Fetches authors and limits the feed.
        finally { session.close(); } // Closes the session.
    } // Ends latestPosts.
    public List<Post> postsByUser(Long userId) { // Reads a user's posts.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<Post> query = session.createQuery("select p from Post p join fetch p.user where p.user.id = :userId order by p.createdAt desc", Post.class); query.setParameter("userId", userId); return query.getResultList(); } // Binds the user id.
        finally { session.close(); } // Closes the session.
    } // Ends postsByUser.
    public List<Post> feedForUser(Long userId) { // Reads posts by this user and people they follow.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<Post> query = session.createQuery("select p from Post p join fetch p.user where p.user.id = :userId or p.user.id in (select f.following.id from Follower f where f.follower.id = :userId) order by p.createdAt desc", Post.class); query.setParameter("userId", userId); return query.getResultList(); } // Executes feed HQL.
        finally { session.close(); } // Closes the session.
    } // Ends feedForUser.
    public List<Post> searchCaptions(String keyword) { // Searches captions.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<Post> query = session.createQuery("select p from Post p join fetch p.user where lower(p.caption) like lower(:keyword) order by p.createdAt desc", Post.class); query.setParameter("keyword", "%" + keyword + "%"); return query.getResultList(); } // Executes caption search.
        finally { session.close(); } // Closes the session.
    } // Ends searchCaptions.
} // Ends PostDAOImpl.
