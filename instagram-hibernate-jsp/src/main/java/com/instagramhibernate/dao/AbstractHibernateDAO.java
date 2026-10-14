package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Supports list results.
import org.hibernate.Session; // Imports Hibernate Session for database work.
import org.hibernate.Transaction; // Imports transaction handling.
import org.hibernate.query.Query; // Imports Hibernate's typed query API.
import com.instagramhibernate.util.HibernateUtil; // Imports the configured SessionFactory provider.
public abstract class AbstractHibernateDAO<T> implements GenericDAO<T> { // Shares explicit Session/Transaction code among DAOs.
    private final Class<T> entityType; // Remembers which entity this DAO manages.
    protected AbstractHibernateDAO(Class<T> entityType) { this.entityType = entityType; } // Receives the entity class from subclasses.
    public T findById(Long id) { // Implements a primary-key lookup.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a database session.
        try { return session.get(entityType, id); } // Reads the entity and closes the session below.
        finally { session.close(); } // Always releases the session.
    } // Ends findById.
    public List<T> findAll() { // Implements a basic HQL list query.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        try { Query<T> query = session.createQuery("from " + entityType.getSimpleName(), entityType); return query.getResultList(); } // Creates and executes HQL.
        finally { session.close(); } // Closes the session in all cases.
    } // Ends findAll.
    public T save(T entity) { // Implements insert/update with an explicit transaction.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction transaction = null; // Prepares a transaction reference for rollback handling.
        try { transaction = session.beginTransaction(); session.saveOrUpdate(entity); transaction.commit(); return entity; } // Saves and commits.
        catch (RuntimeException error) { if (transaction != null) { transaction.rollback(); } throw error; } // Rolls back and rethrows failures.
        finally { session.close(); } // Releases the session.
    } // Ends save.
    public void delete(Long id) { // Deletes an entity by identifier.
        Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
        Transaction transaction = null; // Tracks the transaction.
        try { transaction = session.beginTransaction(); T entity = session.get(entityType, id); if (entity != null) { session.delete(entity); } transaction.commit(); } // Deletes only if found.
        catch (RuntimeException error) { if (transaction != null) { transaction.rollback(); } throw error; } // Rolls back on failure.
        finally { session.close(); } // Releases the session.
    } // Ends delete.
} // Ends AbstractHibernateDAO.
