package com.cognizant.fsd.sbaproject.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.fsd.sbaproject.model.User;
import com.cognizant.fsd.sbaproject.service.UserService;

/**
 * SampleFacade 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */


@Component
public class UserFacade implements BaseFacade {

	Logger logger = LoggerFactory.getLogger(UserFacade.class);

	@Autowired
	UserService userService;

	public void createUser(User user) {
		userService.create(user);
	}

	public void updateUser(User user) {
		userService.update(user);
	}

	public void deleteUser(User user) {
		userService.delete(user);
	}

	public void deleteAllUser() {
		userService.deleteAll();
	}

	public User findUser(User user) {
		return userService.find(user);
	}
}
