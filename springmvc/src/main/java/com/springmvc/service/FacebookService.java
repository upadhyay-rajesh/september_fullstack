package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.FacebookDAO;
import com.springmvc.dao.FacebookDAOInterface;
import com.springmvc.entity.FacebookUser;

@Service
public class FacebookService implements FacebookServiceInterface {
	
	@Autowired
	private FacebookDAOInterface fd;  //FacebookDAOInterface fd = new FacebookDAO();

	@Override
	public int createProfileService(FacebookUser fb) {
		
		return fd.createProfileDAO(fb);
	}

	@Override
	public int loginProfileService(FacebookUser fb) {
		return fd.loginProfileDAO(fb);
	}

}
