/**
 * 
 */
package com.my.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.web.entity.User;

@Controller
public class MyController {
	private Map<String,User> users=new HashMap<String,User>();
	
	public MyController(){
		users.put("1", new User("tom","m","20","aa"));
		users.put("2", new User("jerry","f","20","bb"));
		users.put("3", new User("jeson","m","25","cc"));
		users.put("4", new User("jack","m","30","dd"));
		
	}
	
	@RequestMapping("login")
	public String hello(
			String username,
			String password
			
			){
		if (username.equals("admin") && password.equals("admin")){
			
			return "sucess";
			
		}else
		return "fail";
	}
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("user", users);
		return "list";
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());
		return "add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(User user){
		users.put(user.getName(), user);
		return "redirect:list";
	}
}
