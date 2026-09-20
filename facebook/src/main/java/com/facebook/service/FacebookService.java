package com.facebook.service;

import java.util.ArrayList;

import com.facebook.dao.FacebookDAO;
import com.facebook.entity.FacebookUser;

public class FacebookService {

	public int createProfileService(FacebookUser fc) {
		FacebookDAO fd = new FacebookDAO();
		int i =fd.createProfileDAO(fc);
		return i;
	}

	public FacebookUser viewProfileService(FacebookUser fu) {
		FacebookDAO fd = new FacebookDAO();
		FacebookUser i =fd.viewProfileDAO(fu);
		return i;
	}

	public boolean editProfileService(FacebookUser fu) {
		FacebookDAO fd = new FacebookDAO();
		return fd.editProfileDAO(fu);
	}

	public boolean deleteProfileService(FacebookUser fu) {
		FacebookDAO fd = new FacebookDAO();
		return fd.deleteProfileDAO(fu);
	}

	public ArrayList<FacebookUser> viewAllProfileService() {
		FacebookDAO fd = new FacebookDAO();
		return fd.viewAllProfileDAO();
	}

}
