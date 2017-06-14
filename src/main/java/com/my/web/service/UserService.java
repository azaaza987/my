package com.my.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.web.entity.User;

@Repository 
public class UserService {
	
	private Map<String, User> users = new HashMap<String, User>();

	public Map<String, User> getUsers() {
		return users; 
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public UserService() {
		users.put("Tom", new User("Tom", "M", "20", "Tom@test.com"));
		users.put("Jerry", new User("Jerry", "F", "21", "Jerry@test.com"));
		users.put("Jason", new User("Jason", "M", "25", "Jason@test.com"));
		users.put("Iva", new User("Iva", "F", "30", "Iva@test.com"));

	}
	
	public Map<String, User> getUserList() {
		return users;
	}

	public Map<String, User> addUser(User user) {
		users.put(user.getName(), user);
		return users;
	}

	public User showUser(String name) {
		return users.get(name);
	}

	public User toUpdate(String name) {
		return users.get(name);
	}

	public Map<String, User> update(String name, User user) {
		users.put(user.getName(), user);
		return users;
	}

	public Map<String, User> delete(String name) {
		users.remove(name);
		return users;
	}
	
}
