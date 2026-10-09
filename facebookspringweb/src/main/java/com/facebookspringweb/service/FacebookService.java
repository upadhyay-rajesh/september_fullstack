package com.facebookspringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebookspringweb.dao.FacebookDAOInterface;
import com.facebookspringweb.entity.FacebookUser;

@Service
public class FacebookService implements FacebookServiceInterface {
	
	@Autowired
	private FacebookDAOInterface fd;

	@Override
	public int createProfileService(FacebookUser fb) {
		// TODO Auto-generated method stub
		return fd.createProfileDAO(fb);
	}

}
