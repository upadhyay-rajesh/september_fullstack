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

}
