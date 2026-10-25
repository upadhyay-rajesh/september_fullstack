package com.instagramspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.instagramspringboot.entity.InstagramUser;
import com.instagramspringboot.service.InstagramServiceInterface;

@Controller
public class MyController {
	
	@Autowired
	private InstagramServiceInterface iService;
	
	@RequestMapping("register")
	public ModelAndView createProfile(@RequestParam("nn") String name, @RequestParam("pp") String password,@RequestParam("ee") String email,@RequestParam("aa") String address) {
		
		InstagramUser iu = new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		int i=iService.createProfileService(iu);
		
		ModelAndView mv=new ModelAndView();
		if(i>0) {
			mv.addObject("message", "Profile created");
			mv.setViewName("result.jsp");
		}
		else {
			mv.addObject("message", "could not create Profile");
			mv.setViewName("register.jsp");
		}
		return mv;
	}

}
