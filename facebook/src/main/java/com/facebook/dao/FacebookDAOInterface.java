package com.facebook.dao;

import java.util.ArrayList;

import com.facebook.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fc);

	FacebookUser viewProfileDAO(FacebookUser fu);

	boolean editProfileDAO(FacebookUser fu);

	boolean deleteProfileDAO(FacebookUser fu);

	ArrayList<FacebookUser> viewAllProfileDAO();

	boolean editProfileAddressDAO(FacebookUser fc);

	boolean editProfilePasswordDAO(FacebookUser fc);

}
