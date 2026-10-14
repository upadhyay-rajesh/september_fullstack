package com.instagramhibernate.dao; // Declares the DAO package.

import java.util.List; // Imports list support.
import org.hibernate.Session; // Imports Hibernate Session.
import org.hibernate.Transaction; // Imports transaction support.
import org.hibernate.query.Query; // Imports HQL Query.
import com.instagramhibernate.entity.User; // Imports User entity.
import com.instagramhibernate.util.HibernateUtil; // Imports SessionFactory utility.

public class UserDAOImpl extends AbstractHibernateDAO<User> implements UserDAO { // Implements UserDAO using Hibernate.
	public UserDAOImpl() {
		super(User.class);
	} // Passes the entity type to the generic DAO.

	public User findByUsername(String username) { // Looks up a unique username.
		Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a Hibernate session.
		try {
			Query<User> query = session.createQuery("from User u where u.username = :username", User.class);
			query.setParameter("username", username);
			return query.uniqueResult();
		} // Binds input safely and returns one user.
		finally {
			session.close();
		} // Closes the session.
	} // Ends findByUsername.

	public User authenticate(String username, String password) { // Validates login credentials for this teaching demo.
		Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
		try {
			Query<User> query = session
					.createQuery("from User u where u.username = :username and u.password = :password", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.uniqueResult();
		} // Executes parameterized HQL.
		finally {
			session.close();
		} // Closes the session.
	} // Ends authenticate.

	public List<User> searchUsers(String keyword) { // Searches username and full name.
		Session session = HibernateUtil.getSessionFactory().openSession(); // Opens a session.
		try {
			Query<User> query = session.createQuery(
					"from User u where lower(u.username) like lower(:keyword) or lower(u.fullName) like lower(:keyword)",
					User.class);
			query.setParameter("keyword", "%" + keyword + "%");
			query.setMaxResults(30);
			return query.getResultList();
		} // Executes limited parameterized search.
		finally {
			session.close();
		} // Closes the session.
	} // Ends searchUsers.
} // Ends UserDAOImpl.
