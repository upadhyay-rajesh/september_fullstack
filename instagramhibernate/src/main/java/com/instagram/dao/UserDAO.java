package com.instagram.dao;

import com.instagram.entity.User;

import jakarta.persistence.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDAO extends BaseDAO<User> {
	public UserDAO() {
		super(User.class);
	}

	public User findByUsername(String username) {
		User vv=null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Query q = ss.createQuery("from User u where u.username=:u");
		q.setParameter("u", username);
		
		List<User> uu = q.getResultList();
		if(uu.size()>0) {
			vv=uu.get(0);
		}
		return vv;
		
		return tx(s -> s.createQuery("from User u where u.username=:u", User.class).setParameter("u", username)
				.uniqueResult());
	}

	public User login(String username, String password) {
		return tx(s -> s.createQuery("from User u where u.username=:u and u.password=:p", User.class)
				.setParameter("u", username).setParameter("p", password).uniqueResult());
	}

	public List<User> search(String q) {
		return tx(s -> s
				.createQuery("from User u where lower(u.username) like lower(:q) or lower(u.fullName) like lower(:q)",
						User.class)
				.setParameter("q", "%" + q + "%").setMaxResults(30).getResultList());
	}
}