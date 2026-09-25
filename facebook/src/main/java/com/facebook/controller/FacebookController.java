package com.facebook.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface{

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
		
		FacebookServiceInterface fs = new FacebookService();
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
		
		FacebookServiceInterface fs = new FacebookService();
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
		
		FacebookServiceInterface fs = new FacebookService();

		
		FacebookUser fc =  fs.viewProfileService(fu);
		
		if(fc!=null) {
			System.out.println("your old details is ");
			System.out.println("Name is "+fc.getName());
			System.out.println("Password is "+fc.getPassword());
			System.out.println("Email is "+fc.getEmail());
			System.out.println("Address is "+fc.getAddress());
			
			System.out.println("edit record menu");
			System.out.println("press 1 to edit password");
			System.out.println("press 2 to edit address");
			System.out.println("enter choice to edit");
			int ec=sc.nextInt();
			switch(ec) {
			case 1: editPassword(fc);
				break;
			case 2:editAddress(fc);
				break;
				default: System.out.println("wrong choice");
			}
		}
		else {
			System.out.println("user not exist in database");
		}
		
	}

	private void editAddress(FacebookUser fc) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter new address");
		String address=sc.next();
		
		fc.setAddress(address);
		
		FacebookServiceInterface fs = new FacebookService();
		boolean b =  fs.editProfileAddressService(fc);
		
		if(b) {
			System.out.println("address edited");
		}
		
		
	}

	private void editPassword(FacebookUser fc) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter new password");
		String password=sc.next();
		
		fc.setPassword(password);
		
		FacebookServiceInterface fs = new FacebookService();
		boolean b =  fs.editProfilePasswordService(fc);
		
		if(b) {
			System.out.println("password edited");
		}
		
	}

	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to delete profile");
		String email=sc.next();
		
		FacebookUser fu =new FacebookUser();
		fu.setEmail(email);
		
		FacebookServiceInterface fs = new FacebookService();
		boolean fc =  fs.deleteProfileService(fu);
		
		if(fc) {
			System.out.println("profile deleted");
		}
		
	}

	public void viewAllProfileController() {
		FacebookServiceInterface fs = new FacebookService();
		ArrayList<FacebookUser> fc =  fs.viewAllProfileService();
		
		System.out.println(fc.size()+" record found in database");
		
		for(FacebookUser f:fc) {
			System.out.println("******************************** ");
			System.out.println("Name is "+f.getName());
			System.out.println("Password is "+f.getPassword());
			System.out.println("Email is "+f.getEmail());
			System.out.println("Address is "+f.getAddress());
		}
		
		
	}

	public void sendfriendRequestController() {
		// TODO Auto-generated method stub
		
	}

}
