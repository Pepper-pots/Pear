package com.rev.dao;

import java.util.List;

import com.rev.entity.User;



public interface UserDAO  {

	public List<User> viewAllUsers();
	public User addUser(User user);
	public User getUserByUsername(String uname);
	public User updateUser(User user);
	public User getUserById(long id);
	public void deleteUserById(long id);
}
