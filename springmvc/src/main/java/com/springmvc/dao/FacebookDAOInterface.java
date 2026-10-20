package com.springmvc.dao;

import com.springmvc.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	int loginProfileDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

	int editProfileDAO(FacebookUser fb);

}
