package com.rev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rev.entity.User;
import com.rev.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	@GetMapping(value="/")
	public List<User> getUser(){
		List<User> al=us.getAllUsers();
		return al;
	}
	
	@PostMapping(value="/")
	public User createUser(@RequestBody User user) {
		return us.createUser(user);
	}
	@PutMapping(value="/")
	public User updateUser(@RequestBody User user) {
		return us.updateUser(user);
	}
	@PostMapping(value="/login")
	public User login(@RequestBody User user) {
	
		return us.Authenticate(user);
	}
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable int id){
		return us.getUserById(id);
	}
	@DeleteMapping(value="/{id}")
	public void deletById(@PathVariable int id){
		us.deleteUser(id);
	}
	
}
