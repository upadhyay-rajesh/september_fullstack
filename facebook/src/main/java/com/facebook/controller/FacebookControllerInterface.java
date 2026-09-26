package com.facebook.controller;

import com.facebook.exception.UserNotFoundException;

public interface FacebookControllerInterface {

	void createProfileController()throws Exception;

	void viewProfileController();

	void editProfileController();

	void viewAllProfileController();

	void deleteProfileController()throws UserNotFoundException;

	void sendfriendRequestController();

}
