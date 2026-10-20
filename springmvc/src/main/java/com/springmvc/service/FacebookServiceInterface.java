package com.springmvc.service;

import com.springmvc.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	int loginProfileService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

	int editProfileService(FacebookUser fb);

}
