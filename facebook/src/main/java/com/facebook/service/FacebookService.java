package com.facebook.service;

import java.util.ArrayList;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface{

	public int createProfileService(FacebookUser fc) throws Exception{
		FacebookDAOInterface fd = new FacebookDAO();
		int i =fd.createProfileDAO(fc);
		return i;
	}

	public FacebookUser viewProfileService(FacebookUser fu) {
		FacebookDAOInterface fd = new FacebookDAO();
		FacebookUser i =fd.viewProfileDAO(fu);
		return i;
	}

	public boolean editProfileService(FacebookUser fu) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.editProfileDAO(fu);
	}

	public boolean deleteProfileService(FacebookUser fu) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.deleteProfileDAO(fu);
	}

	public ArrayList<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.viewAllProfileDAO();
	}

	@Override
	public boolean editProfileAddressService(FacebookUser fc) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.editProfileAddressDAO(fc);
	}

	@Override
	public boolean editProfilePasswordService(FacebookUser fc) {
		FacebookDAOInterface fd = new FacebookDAO();
		return fd.editProfilePasswordDAO(fc);
	}

}
