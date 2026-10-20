package com.socialbook.dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class SocialDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session s() {
		return sessionFactory.getCurrentSession();
	}

	public <T> T save(T entity) {
		s().saveOrUpdate(entity);
		return entity;
	}

	public <T> T get(Class<T> type, Long id) {
		return s().get(type, id);
	}

	public <T> List<T> all(Class<T> type) {
		return s().createQuery("from " + type.getSimpleName() + " order by id desc", type).setMaxResults(100).list();
	}

	public <T> void delete(T entity) {
		s().delete(entity);
	}

	public <T> List<T> query(String hql, Class<T> type, Object... params) {
		org.hibernate.query.Query<T> q = s().createQuery(hql, type);
		for (int i = 0; i < params.length; i++)
			q.setParameter(i + 1, params[i]);
		return q.setMaxResults(100).list();
	}

	public int update(String hql, Object... params) {
		org.hibernate.query.Query<?> q = s().createQuery(hql);
		for (int i = 0; i < params.length; i++)
			q.setParameter(i + 1, params[i]);
		return q.executeUpdate();
	}
}
