package com.facebook.service;

import java.util.ArrayList;
import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	List<FacebookUser> viewAllProfileService();

	boolean deleteProfileService(FacebookUser fu);

	boolean editProfileService(FacebookUser fu);

	FacebookUser viewProfileService(FacebookUser fu);

	int createProfileService(FacebookUser fc)throws Exception;

	boolean editProfileAddressService(FacebookUser fc);

	boolean editProfilePasswordService(FacebookUser fc);

}
