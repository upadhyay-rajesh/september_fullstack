package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.State;

public interface FacebookServicInterface {

	int createProfileService(FacebookUser fb);

	boolean loginProfileService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

	List<FacebookUser> viewAllProfileService();

	int deleteProfileService(FacebookUser fb);

	 List<FacebookUser> searchProfileService();

	 int editProfileService(FacebookUser fb);

	 boolean checkEmailService(FacebookUser fb);

	 List<Country> loadCountryService();

	 List<State> loadStateService(Country c);

}
