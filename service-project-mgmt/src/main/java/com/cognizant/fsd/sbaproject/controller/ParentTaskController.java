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
import com.cognizant.fsd.sbaproject.facade.ParentTaskFacade;
import com.cognizant.fsd.sbaproject.model.JSONResponseModel;
import com.cognizant.fsd.sbaproject.model.ParentTask;

@RestController
public class ParentTaskController extends AbstractController  {

	Logger logger = LoggerFactory.getLogger(ParentTaskController.class);

	@Autowired
	private ParentTaskFacade parentTaskFacade;


	@GetMapping("/parentTask/{parentId}")
	public ResponseEntity<JSONResponseModel> getParentTask(@PathVariable String parentId, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			ParentTask parentTask = parentTaskFacade.findParentTask(new ParentTask(parentId));

			jsonResponseModel = setJSONResponseVO(parentTask, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}


	@PostMapping("/parentTask")
	public ResponseEntity<JSONResponseModel> updateParentTask(@RequestBody ParentTask parentTask, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			parentTaskFacade.updateParentTask(parentTask);

			jsonResponseModel = setJSONResponseVO(true, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@PutMapping("/parentTask")
	public ResponseEntity<JSONResponseModel> createParentTask(@RequestBody ParentTask parentTask, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			parentTaskFacade.createParentTask(parentTask);

			jsonResponseModel = setJSONResponseVO(true, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@DeleteMapping("/parentTask/{parentId}")
	public ResponseEntity<JSONResponseModel> deleteParentTask(@PathVariable String parentId, HttpServletRequest request,  HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			parentTaskFacade.deleteParentTask(new ParentTask(parentId));

			jsonResponseModel = setJSONResponseVO(true, response);
		}catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE, ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}


}
