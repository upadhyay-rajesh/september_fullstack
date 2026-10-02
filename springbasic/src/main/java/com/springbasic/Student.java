package com.springbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("bb")
public class Student {
	
	@Autowired
	private TeacherInterface ttt;
	
	/*
	//adapter
	public void setTtt(TeacherInterface ttt) {
		this.ttt = ttt;
	}
	*/

	public void useTeacher() {
		ttt.teach();
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("abc.xml");
		//TeacherInterface t1 = new Teacher();
		//t1 variable is local and it is object of Teacher
		//how to store local variable t1 inside global variable ttt
		//via setter methods
		Student st=(Student)ctx.getBean("bb");
	//	st.setTtt(t1);//here we are injecting Teacher class object inside setter(adpter) of student class
		              //this is known as dependency injection
		
		st.useTeacher();
		

	}

}
