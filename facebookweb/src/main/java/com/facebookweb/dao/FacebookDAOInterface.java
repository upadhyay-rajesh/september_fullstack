package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	boolean loginProfileDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

	List<FacebookUser> viewAllProfileDAO();

	int deleteProfileDAO(FacebookUser fb);

	 List<FacebookUser> searchProfileDAO();

}
