/**
 * 
 */
package com.my.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.web.entity.User;

@Controller
public class MyController {
	private Map<String,User> users=new HashMap<String,User>();
	
	public MyController(){
		users.put("Tom", new User("Tom","M","20","Tom@test.com"));
		users.put("Jerry", new User("Jerry","F","21","Jerry@test.com"));
		users.put("Jason", new User("Jason","M","25","Jason@test.com"));
		users.put("Iva", new User("Iva","F","30","Iva@test.com"));
		
	}
	
	@RequestMapping("login")
	public String hello(
			String username,
			String password
			
			){
		if (username.equals("Admin") && password.equals("Admin")){
			
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
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String show(@PathVariable String name,Model model){
		model.addAttribute(users.get(name));
		return "show";
	}
	
	@RequestMapping(value="/{name}/update",method=RequestMethod.GET)
	public String update(@PathVariable String name,Model model){
		model.addAttribute(users.get(name));
		return "update";
	}
	
	@RequestMapping(value="/{name}/update",method=RequestMethod.POST)
	public String update(@PathVariable String name,User user){
		users.put(name, user);
		return "redirect:../list";
	}
	@RequestMapping(value="/{name}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String name){
		users.remove(name);
		return "redirect:../list";
	}
}
