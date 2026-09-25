package com.facebook.service;

import java.util.ArrayList;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	ArrayList<FacebookUser> viewAllProfileService();

	boolean deleteProfileService(FacebookUser fu);

	boolean editProfileService(FacebookUser fu);

	FacebookUser viewProfileService(FacebookUser fu);

	int createProfileService(FacebookUser fc);

	boolean editProfileAddressService(FacebookUser fc);

	boolean editProfilePasswordService(FacebookUser fc);

}
