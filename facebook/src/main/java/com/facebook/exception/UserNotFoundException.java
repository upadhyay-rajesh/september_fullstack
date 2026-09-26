package com.facebook.exception;
//custom exception
//
public class UserNotFoundException extends Exception{
	String message;
	
	public UserNotFoundException(String m){
		message=m;
	}
	
	public String toString() {
		return "ha ha ha i am custom exception "+message;
	}
}
