package com.facebookweb.service;

import java.util.List;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServicInterface {

	@Override
	public int createProfileService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.createProfileDAO(fb);
	}

	@Override
	public boolean loginProfileService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.loginProfileDAO(fb);
	}

	@Override
	public FacebookUser viewProfileService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.viewProfileDAO(fb);
	}

	@Override
	public List<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.viewAllProfileDAO();
	}

	@Override
	public int deleteProfileService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.deleteProfileDAO(fb);
	}

	@Override
	public  List<FacebookUser> searchProfileService() {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.searchProfileDAO();
		
	}

}
