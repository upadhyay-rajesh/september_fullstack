package com.facebookspringweb.dao;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.facebookspringweb.entity.FacebookUser;

@Repository
public class FacebookDAO implements FacebookDAOInterface {

	@Override
	public int createProfileDAO(FacebookUser fb) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		EntityTransaction et = ss.getTransaction();
		et.begin();
			ss.save(fb);
			et.commit();
		return 1;
	}

}
