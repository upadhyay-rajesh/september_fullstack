package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.FacebookUser;
import com.springmvc.service.FacebookService;
import com.springmvc.service.FacebookServiceInterface;

@Controller
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs; //FacebookServiceInterface fs = new FacebookService();
	
	@RequestMapping("register.htm") //this must match with action part of jsp
	public ModelAndView createProfile(@RequestParam("n") String name, @RequestParam("pass") String password, @RequestParam("ee") String email, @RequestParam("aa") String address)
	{
		//@RequestParam("n") String name    ======== String name = request.getParameter("n");
		
		
		FacebookUser fb = new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
				
		int i= fs.createProfileService(fb);
		
		ModelAndView mv = new ModelAndView();
		if(i>0) {
		mv.addObject("myname", name);
		mv.addObject("mypassword", password);
		mv.addObject("myemail", email);
		mv.addObject("myaddress", address);
		
		mv.setViewName("register.jsp");
		}
		return mv;
		
	}
	@RequestMapping("login.htm") 
	public ModelAndView loginProfile( @RequestParam("pass") String password, @RequestParam("ee") String email)
	{
		
		System.out.println(email+"  "+password);
		
		FacebookUser fb = new FacebookUser();
	
		fb.setPassword(password);
		fb.setEmail(email);
		
				
		int i= fs.loginProfileService(fb);
		
		ModelAndView mv = new ModelAndView();
		if(i>0) {
		mv.addObject("myemail", email);
		mv.setViewName("home.jsp");
		}
		else {
			mv.addObject("loginfailedmessage", "Invalid id and password");
			mv.setViewName("login.jsp");
		}
		return mv;
		
	}
	@RequestMapping("view.htm") 
	public ModelAndView viewProfile( @RequestParam("userid") String email)
	{
		FacebookUser fb = new FacebookUser();
		fb.setEmail(email);
		
				
		FacebookUser ff= fs.viewProfileService(fb);
		
		ModelAndView mv = new ModelAndView();
		if(ff!=null) {
		mv.addObject("myuser", ff);
		mv.setViewName("view.jsp");
		}
		
		return mv;
		
	}
	@RequestMapping("edit.htm") 
	public ModelAndView editProfile( @RequestParam("userid") String email)
	{
		FacebookUser fb = new FacebookUser();
		fb.setEmail(email);
		
				
		FacebookUser ff= fs.viewProfileService(fb);
		
		ModelAndView mv = new ModelAndView();
		if(ff!=null) {
		mv.addObject("myuser", ff);
		mv.setViewName("edit.jsp");
		}
		
		return mv;
		
	}
	@RequestMapping("edit1.htm") //this must match with action part of jsp
	public ModelAndView edit1Profile(@RequestParam("n") String name, @RequestParam("pass") String password, @RequestParam("ee") String email, @RequestParam("aa") String address)
	{
		//@RequestParam("n") String name    ======== String name = request.getParameter("n");
		
		
		FacebookUser fb = new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
				
		int i= fs.editProfileService(fb);
		
		ModelAndView mv = new ModelAndView();
		if(i>0) {
		mv.addObject("mymessage", "profile edited");
	
		
		mv.setViewName("editsuccess.jsp");
		}
		return mv;
		
	}

}
