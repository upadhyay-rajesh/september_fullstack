package com.facebookspringweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.facebookspringweb.entity.FacebookUser;
import com.facebookspringweb.service.FacebookServiceInterface;

@Controller
public class FacebookController {
	//FacebookServiceInterface fs = new FacebookService();
	@Autowired //@Autowired will inform to BeanFactory class of spring to create object of FacebookService class as above
	FacebookServiceInterface fs;
	
	@RequestMapping("register.htm")
	public ModelAndView createProfile(@RequestParam("n") String name,@RequestParam("pass") String password,@RequestParam("ee") String email,@RequestParam("aa") String address) {
		//@RequestParam("n") String name   is equal to String name = request.getParameter("n");
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		int i=fs.createProfileService(fb);
		
		
		ModelAndView mv = new ModelAndView();
		if(i>0) {
		mv.addObject("message", "your profile created successfully");
		mv.addObject("p1", password);
		mv.addObject("e1", email);
		
		}
		
		mv.setViewName("register.jsp");
		return mv;
	}
	@RequestMapping("login.htm")
	public ModelAndView loginProfile() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	@RequestMapping("view.htm")
	public ModelAndView viewProfile() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	@RequestMapping("edit.htm")
	public ModelAndView editProfile() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	@RequestMapping("viewAll.htm")
	public ModelAndView viewAllProfile() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
