package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rev.dao.UserDAO;
import com.rev.entity.User;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO ud;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		List<User> userList= ud.viewAllUsers();
		return userList;
	}

	@Override
	@Transactional
	public User createUser(User user) {
	
		user.setPassword(encoder.encode(user.getPassword()));
		return ud.addUser(user);
	}

	@Override
	
	@Transactional
	public User Authenticate(User user) {
		
		try {
		User temp= ud.getUserByUsername(user.getUserName());
		
		if(encoder.matches(user.getPassword(), temp.getPassword())) {
            return temp;
        }
        else {
            return null;
        }
		}
		catch(NullPointerException e)
		{
			return null;
		}
	}

	@Override
	@Transactional
	public User getUserById(long id) {
		return ud.getUserById(id);
	}

	@Override
	@Transactional
	public void deleteUser(long id) {
		ud.deleteUserById(id);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
			user.setPassword(encoder.encode(user.getPassword()));
			return ud.updateUser(user);
		
		
	}
	

}
