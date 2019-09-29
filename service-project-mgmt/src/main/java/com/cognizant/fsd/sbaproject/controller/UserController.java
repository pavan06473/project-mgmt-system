package com.cognizant.fsd.sbaproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.fsd.sbaproject.constants.ServiceConstants;
import com.cognizant.fsd.sbaproject.facade.UserFacade;
import com.cognizant.fsd.sbaproject.model.JSONResponseModel;
import com.cognizant.fsd.sbaproject.model.User;

@RestController
public class UserController extends AbstractController  {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserFacade userFacade;


	@GetMapping("/users/{userId}")
	public ResponseEntity<JSONResponseModel> getUser(@PathVariable String userId, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			User user = userFacade.findUser(new User(userId));

			jsonResponseModel = setJSONResponseVO(user, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}


	@PostMapping("/users")
	public ResponseEntity<JSONResponseModel> updateUser(@RequestBody User user, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			userFacade.updateUser(user);

			jsonResponseModel = setJSONResponseVO(true, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@PutMapping("/users")
	public ResponseEntity<JSONResponseModel> createUser(@RequestBody User user, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			userFacade.createUser(user);

			jsonResponseModel = setJSONResponseVO(true, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<JSONResponseModel> deleteUser(@PathVariable String userId, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			userFacade.deleteUser(new User(userId));

			jsonResponseModel = setJSONResponseVO(true, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}


}
