package com.springcoreseptember;

import org.springframework.stereotype.Component;

@Component("atrainer1")
public class Trainer1 implements TrainerInterface{
	public void teach() {
		System.out.println("trainer1 is teaching");
	}
	
	public void firstRun() {
		System.out.println("i am init method");
	}
	public void lastRun() {
		System.out.println("i am destroy method");
	}
}
