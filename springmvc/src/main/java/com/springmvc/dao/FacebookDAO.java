package com.springmvc.dao;

import java.util.List;

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
		int i=0;
		Session ss = sf.openSession();
		Query q = ss.createQuery("from FacebookUser f where f.email=:em and f.password=:pw");
		q.setParameter("em", fb.getEmail());
		q.setParameter("pw", fb.getPassword());
		List<FacebookUser> ll = q.getResultList();
		if(ll.size()>0) {
			i=1;
		}
		return i;
	}

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fb) {
		FacebookUser ff=null;
		Session ss = sf.openSession();
		Query q = ss.createQuery("from FacebookUser f where f.email=:em");
		q.setParameter("em", fb.getEmail());
		
		List<FacebookUser> ll = q.getResultList();
		if(ll.size()>0) {
			ff=ll.get(0);
		}
		return ff;
	}

	@Override
	public int editProfileDAO(FacebookUser fb) {
		int i=0;
		Session ss = sf.openSession();
		EntityTransaction et = ss.getTransaction();
		et.begin();
		Query q = ss.createQuery("update FacebookUser f set f.name=:nm , f.password=:pw, f.address=:ad where f.email=:em ");
		
		q.setParameter("em", fb.getEmail());
		q.setParameter("pw", fb.getPassword());
		q.setParameter("nm", fb.getName());
		q.setParameter("ad", fb.getAddress());
		i = q.executeUpdate();
		et.commit();
		return i;
	}

}
