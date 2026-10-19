package com.springmvc.dao;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.FacebookUser;


@Repository
public class FacebookDAO implements FacebookDAOInterface {
	@Autowired
	private SessionFactory sf; //SessionFactory sf = new configuration().configure().buildSessionFactory();

	@Override
	//@Transactional
	public int createProfileDAO(FacebookUser fb) {
		Session ss = sf.openSession();
		EntityTransaction et = ss.getTransaction();
		et.begin();
		ss.save(fb);
		et.commit();
		return 1;
	}

	@Override
	public int loginProfileDAO(FacebookUser fb) {
		Session ss = sf.openSession();
		Query q = ss.createQuery("");
		return 0;
	}

}
