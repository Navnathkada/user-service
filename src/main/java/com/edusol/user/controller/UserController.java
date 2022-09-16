package com.edusol.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.user.model.User;
import com.edusol.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@PostMapping
	public User addUser(@RequestBody User user) {
	   return userservice.addUser(user);
	}
	
    @GetMapping
	public List<User> getUsers(){
		return userservice.getUsers();
	}
    
    @GetMapping("/city")
    public  List<User> getUsersByCityName(@RequestParam String city) {
    	return userservice.getUsersByCity(city);
		
	}
    
    @GetMapping("/email")
    public  List<User> getUsersByEmail(@RequestParam String email) {
    	return userservice.getUsersByEmail(email);
		
	}
    
    @PutMapping
    public String updateUser(@RequestBody User user) {
    
    	return userservice.updateUser(user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
    	return userservice.deleteUser(id);
    }
    
    @DeleteMapping("/{email}")
    public String deleteUserByEmail(@PathVariable String email) {
    	// return userservice.deleteUser(id);
    	return null;
    }

}
