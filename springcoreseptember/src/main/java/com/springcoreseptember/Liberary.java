package com.springcoreseptember;

import org.springframework.stereotype.Component;

@Component("clib")
public class Liberary implements LiberaryInterface{

	@Override
	public void issueBooks() {
		System.out.println("book issued");
		
	}

}
