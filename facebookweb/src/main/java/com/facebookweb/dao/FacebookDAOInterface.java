package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.State;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	boolean loginProfileDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

	List<FacebookUser> viewAllProfileDAO();

	int deleteProfileDAO(FacebookUser fb);

	 List<FacebookUser> searchProfileDAO();

	 int editProfileDAO(FacebookUser fb);

	 boolean checkEmailDAO(FacebookUser fb);

	 List<Country> loadCountryDAO();

	 List<State> loadStateDAO(Country c);

}
