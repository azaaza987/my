/**
 * 
 */
package com.my.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.web.entity.User;
import com.my.web.service.UserService;

@Controller
public class MyController {
	
	@Autowired  
	private UserService userService ;
	
	@RequestMapping("login")
	public String hello(String username, String password

	) {
		if (username.equals("Admin") && password.equals("Admin")) {

			return "sucess";

		} else
			return "fail";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", userService.getUserList());
		return "list";
	}

	// this method used to direct to Add page
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(User user) {
		userService.addUser(user);
		return "redirect:list";
	}

	// This method used to direct to update page
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String show(@PathVariable String name, Model model) {
		model.addAttribute(userService.showUser(name));
		return "show";
	}

	@RequestMapping(value = "/{name}/update", method = RequestMethod.GET)
	public String update(@PathVariable String name, Model model) {
		model.addAttribute(userService.showUser(name));
		return "update";
	}

	@RequestMapping(value = "/{name}/update", method = RequestMethod.POST)
	public String update(@PathVariable String name, User user) {
		userService.update(name, user);
		return "redirect:../list";
	}

	@RequestMapping(value = "/{name}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable String name) {
		userService.delete(name);
		return "redirect:../list";
	}
}
