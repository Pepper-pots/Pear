package com.rev.service;

import java.util.List;

import com.rev.entity.User;

public interface UserService {
public List<User> getAllUsers();
public User createUser(User user);
public User Authenticate(User user);
public User getUserById(long id);
public void deleteUser(long id);
public User updateUser(User user);
}
