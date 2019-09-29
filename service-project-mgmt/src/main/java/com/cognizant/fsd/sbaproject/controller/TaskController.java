package com.cognizant.fsd.sbaproject.controller;

import java.util.List;

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
import com.cognizant.fsd.sbaproject.facade.TaskFacade;
import com.cognizant.fsd.sbaproject.model.JSONResponseModel;
import com.cognizant.fsd.sbaproject.model.Task;

@RestController
public class TaskController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TaskFacade taskFacade;

	@GetMapping("/tasks")
	public ResponseEntity<JSONResponseModel> getTasks(HttpServletRequest request, HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			List<Task> task = taskFacade.findAll();

			jsonResponseModel = setJSONResponseVO(task, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<JSONResponseModel> getTask(@PathVariable String taskId, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			Task task = taskFacade.findTask(new Task(taskId));

			jsonResponseModel = setJSONResponseVO(task, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<JSONResponseModel> updateTask(@PathVariable String taskId, @RequestBody Task task,
			HttpServletRequest request, HttpServletResponse response) {
		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			taskFacade.updateTask(task);

			jsonResponseModel = setJSONResponseVO(true, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@PostMapping("/tasks")
	public ResponseEntity<JSONResponseModel> createTask(@RequestBody Task task, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			taskFacade.createTask(task);

			jsonResponseModel = setJSONResponseVO(true, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@DeleteMapping("/tasks/{taskId}")
	public ResponseEntity<JSONResponseModel> deleteTask(@PathVariable String taskId, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			taskFacade.deleteTask(new Task(taskId));

			jsonResponseModel = setJSONResponseVO(true, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

}
