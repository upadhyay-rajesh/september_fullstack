package com.facebookweb.service;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServicInterface {

	@Override
	public int createProfileService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.createProfileDAO(fb);
	}

}
