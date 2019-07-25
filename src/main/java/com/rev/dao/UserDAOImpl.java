package com.rev.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rev.entity.User;
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFact;
	
	@Override
	public List<User> viewAllUsers() {
		ArrayList<User> userList = new ArrayList<>();
		Query query = sessionFact.getCurrentSession().createQuery("from User");
		userList = (ArrayList<User>) query.getResultList();
		return userList;
	}

	@Override
	public User addUser(User user) {
		sessionFact.getCurrentSession().save(user);
		return user;
	}

	@Override
	public User getUserByUsername(String uname) {
		Criteria crit = sessionFact.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq("userName",uname));
		 User result= (User)crit.uniqueResult();
		 return result;
	}

	@Override
	public User updateUser(User user) {
		sessionFact.getCurrentSession().update(user);
		return user;
	}

	@Override
	public User getUserById(long id) {
		return sessionFact.getCurrentSession().get(User.class, id);
		
	}

	@Override
	public void deleteUserById(long id) {
		User temp =sessionFact.getCurrentSession().get(User.class, id);
		sessionFact.getCurrentSession().delete(temp);
	}

	
}
