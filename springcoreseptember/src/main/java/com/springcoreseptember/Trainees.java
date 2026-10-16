package com.springcoreseptember;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Trainees {
	private TrainerInterface ttt;
	private LiberaryInterface lll;
	
	
	public void setLll(LiberaryInterface lll) {
		this.lll = lll;
	}

	//adapter
	public void setTtt(TrainerInterface ttt) {
		this.ttt = ttt;
	}

	public void useTrainerFacilities() {
		ttt.teach();
		lll.issueBooks();
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("abc.xml");
		
		
		//TrainerInterface tt2 = new Trainer();
		
		//Trainees t1 = new Trainees();
		
		Trainees t1 = (Trainees)ctx.getBean("btrainees");
		//t1.setTtt(tt2);  //dependency injection, here trainees want to use trainer facilities so creating trainer object and passing to setter method to access trainer globally
		
		t1.useTrainerFacilities();

	}

}
