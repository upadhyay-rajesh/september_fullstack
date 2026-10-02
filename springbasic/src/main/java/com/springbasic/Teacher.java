package com.springbasic;

import org.springframework.stereotype.Component;

@Component
public class Teacher implements TeacherInterface{
	public void teach() {
		System.out.println("teacher is teaching java!");
	}
}
