package com.cognizant.fsd.sbaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fsd.sbaproject.model.User;
import com.cognizant.fsd.sbaproject.mongodb.dao.UserDao;


@Service("UserService")
public class UserService {

	@Autowired
	UserDao userDao;

	public void create(User user) {
		userDao.create(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public void deleteAll() {
		userDao.deleteAll();
	}

	public User find(User user) {
		return userDao.find(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}
}