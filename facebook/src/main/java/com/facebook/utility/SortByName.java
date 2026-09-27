package com.facebook.utility;

import java.util.Comparator;

import com.facebook.entity.FacebookUser;

public class SortByName implements Comparator<FacebookUser> {

	@Override
	public int compare(FacebookUser o1, FacebookUser o2) {
		
		return  o1.getName().compareTo(o2.getName());
	}

}
