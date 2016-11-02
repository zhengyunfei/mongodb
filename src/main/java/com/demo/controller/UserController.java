package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.pojo.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView index () {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/save")
	public void saveUser (User user) {
		userService.saveUser(user);
	}
	
	@RequestMapping("/find")
	@SuppressWarnings("unused")
	public ModelAndView findUser (String name) {
		User user = userService.findUser(name);
		return new ModelAndView("index");
	}
}
