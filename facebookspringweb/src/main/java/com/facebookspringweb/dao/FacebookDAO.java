package com.facebookspringweb.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

	@Override
	public int loginProfileDAO(FacebookUser fb) {
		int i=0;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Query q = ss.createNamedQuery("loginuser");
		q.setParameter("em", fb.getEmail());
		q.setParameter("pw", fb.getPassword());
		
		List<FacebookUser> ff =  q.getResultList();
		if(ff.size()>0) {
			i=1;
		}
		return i;
	}

}
