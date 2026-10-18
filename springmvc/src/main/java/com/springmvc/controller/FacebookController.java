package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookController {
	
	
	@RequestMapping("register.htm")
	public ModelAndView createProfile(@RequestParam("n") String name, @RequestParam("pass") String password, @RequestParam("ee") String email, @RequestParam("aa") String address)
	{
		//@RequestParam("n") String name    ======== String name = request.getParameter("n");
		
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("myname", name);
		mv.addObject("mypassword", password);
		mv.addObject("myemail", email);
		mv.addObject("myaddress", address);
		
		mv.setViewName("register.jsp");
		return mv;
		
	}

}
