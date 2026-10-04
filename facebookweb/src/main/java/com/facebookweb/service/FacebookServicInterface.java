package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.FacebookUser;

public interface FacebookServicInterface {

	int createProfileService(FacebookUser fb);

	boolean loginProfileService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

	List<FacebookUser> viewAllProfileService();

	int deleteProfileService(FacebookUser fb);

	 List<FacebookUser> searchProfileService();

}
