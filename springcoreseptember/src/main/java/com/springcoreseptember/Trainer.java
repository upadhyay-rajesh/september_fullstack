package com.springcoreseptember;

import org.springframework.stereotype.Component;

@Component("atrainer")
public class Trainer implements TrainerInterface{
	public void teach() {
		System.out.println("trainer is teaching");
	}
	
	//@PostConstruct
	public void firstRun() {
		System.out.println("i am init method");
	}
	
	//@PreDestroy
	public void lastRun() {
		System.out.println("i am destroy method");
	}
}
