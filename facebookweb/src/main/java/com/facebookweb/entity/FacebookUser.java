package com.facebookweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //this annotation indicate which entity class hibernate will map on table and based on this it will create table.
public class FacebookUser {
	private String name;
	private String password;
	@Id  //it will indicate email will be primary key
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
