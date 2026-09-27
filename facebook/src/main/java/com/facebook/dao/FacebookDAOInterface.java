package com.facebook.dao;

import java.util.ArrayList;
import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fc)throws Exception;

	FacebookUser viewProfileDAO(FacebookUser fu);

	boolean editProfileDAO(FacebookUser fu);

	boolean deleteProfileDAO(FacebookUser fu);

	List<FacebookUser> viewAllProfileDAO();

	boolean editProfileAddressDAO(FacebookUser fc);

	boolean editProfilePasswordDAO(FacebookUser fc);

}
