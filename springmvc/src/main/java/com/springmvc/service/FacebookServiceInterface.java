package com.springmvc.service;

import com.springmvc.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	int loginProfileService(FacebookUser fb);

}
