package com.springcoreseptember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("btrainees")
public class Trainees {
	@Autowired   // if we will write @Autowired above to any interface reference then BeanFactory class will check, which Bean is using that interface and it will creatwe object of that bean and will inject
	             //here ttt indicates TrainerInterface reference so BeanFactory will check which class is implementing TrainerInterface , here Trainer class is implementing TrainerInterface so it will create object of Trainer and inject inside ttt.
	@Qualifier("atrainer1")
	private TrainerInterface ttt;
	
	@Autowired
	@Qualifier("atrainer")
	private TrainerInterface ttt12;
	
	@Autowired
	private LiberaryInterface lll;
	
	/*
	public void setLll(LiberaryInterface lll) {
		this.lll = lll;
	}

	//adapter
	public void setTtt(TrainerInterface ttt) {
		this.ttt = ttt;
	}
	*/

	public void useTrainerFacilities() {
		ttt.teach();
		ttt12.teach();
		lll.issueBooks();
	}

	public static void main(String[] args) {
		
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("abc.xml");
		AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		
		//TrainerInterface tt2 = new Trainer();
		
		//Trainees t1 = new Trainees();
		
		Trainees t1 = (Trainees)ctx.getBean("btrainees");
		//t1.setTtt(tt2);  //dependency injection, here trainees want to use trainer facilities so creating trainer object and passing to setter method to access trainer globally
		
		t1.useTrainerFacilities();
		

	}

}
