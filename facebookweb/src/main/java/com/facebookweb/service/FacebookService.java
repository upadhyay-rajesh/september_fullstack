package com.facebookweb.service;

import java.util.List;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.State;

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

	@Override
	public int editProfileService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.editProfileDAO(fb);
	}

	@Override
	public boolean checkEmailService(FacebookUser fb) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.checkEmailDAO(fb);
	}

	@Override
	public List<Country> loadCountryService() {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.loadCountryDAO();
	}

	@Override
	public List<State> loadStateService(Country c) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.loadStateDAO(c);
	}

}
