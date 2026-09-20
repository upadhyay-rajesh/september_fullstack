package com.facebook.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;

public class FacebookController {

	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		//all above data we have to transfer to service layer so how we should transfer? answer using DTO(DATA TRANSFER OBJECT) design pattern
		//object of which class?
		//entity class like FacebookUser
		
		FacebookUser fc = new FacebookUser();
		fc.setName(name);
		fc.setPassword(password);
		fc.setEmail(email);
		fc.setAddress(address);
		
		FacebookService fs = new FacebookService();
		int i = fs.createProfileService(fc);
		
		if(i>0) {
			System.out.println("your profile created");
		}
		
	}

	public void viewProfileController() {
Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email to view profile");
		String email=sc.next();
		
		FacebookUser fu =new FacebookUser();
		fu.setEmail(email);
		
		FacebookService fs = new FacebookService();
		FacebookUser fc =  fs.viewProfileService(fu);
		
		if(fc!=null) {
			System.out.println("your details is ");
			System.out.println("Name is "+fc.getName());
			System.out.println("Password is "+fc.getPassword());
			System.out.println("Email is "+fc.getEmail());
			System.out.println("Address is "+fc.getAddress());
		}
		else {
			System.out.println("user not exist in database");
		}
		
	}

	public void editProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to edit profile");
		String email=sc.next();
		
		FacebookUser fu =new FacebookUser();
		fu.setEmail(email);
		
		FacebookService fs = new FacebookService();
		boolean fc =  fs.editProfileService(fu);
		
		if(fc) {
			System.out.println("profile edited");
		}
		
	}

	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to delete profile");
		String email=sc.next();
		
		FacebookUser fu =new FacebookUser();
		fu.setEmail(email);
		
		FacebookService fs = new FacebookService();
		boolean fc =  fs.deleteProfileService(fu);
		
		if(fc) {
			System.out.println("profile deleted");
		}
		
	}

	public void viewAllProfileController() {
		FacebookService fs = new FacebookService();
		ArrayList<FacebookUser> fc =  fs.viewAllProfileService();
		
		
	}

	public void sendfriendRequestController() {
		// TODO Auto-generated method stub
		
	}

}
