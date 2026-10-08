package com.facebookspringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookController {
	
	@RequestMapping("register.htm")
	public ModelAndView createProfile(@RequestParam("n") String name,@RequestParam("pass") String password,@RequestParam("ee") String email,@RequestParam("aa") String address) {
		//@RequestParam("n") String name   is equal to String name = request.getParameter("n");
		ModelAndView mv = new ModelAndView();
		mv.addObject("name1", name);
		mv.addObject("p1", password);
		mv.addObject("e1", email);
		mv.addObject("a1", address);
		
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
