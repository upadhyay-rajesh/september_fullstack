package com.facebook.view;

import java.util.Scanner;

import com.facebook.controller.FacebookController;

public class FacebookView {

	public static void main(String[] args) {
		String ss="y";
		Scanner sc=new Scanner(System.in);
		
		while(ss.equals("y")) {
			
			System.out.println(("*****************MAIN MENU**************"));
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to edit profile");
			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to view all profile");
			System.out.println("press 6 to send friend request");
			
			System.out.println("enter choice");
			int c=sc.nextInt();
			
			FacebookController fc = new FacebookController();
			
			switch(c) {
			case 1:fc.createProfileController();
				break;
			case 2:fc.viewProfileController();
				break;
			case 3:fc.editProfileController();
				break;
			case 4:fc.deleteProfileController();
				break;
			case 5:fc.viewAllProfileController();
				break;
			case 6:fc.sendfriendRequestController();
				break;
				default: System.out.println("wrong choice");
			}
			
			System.out.println("do you want  to continue press y/n");
			ss=sc.next();
		}

	}

}
