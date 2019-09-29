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
import com.cognizant.fsd.sbaproject.facade.ProjectFacade;
import com.cognizant.fsd.sbaproject.model.JSONResponseModel;
import com.cognizant.fsd.sbaproject.model.Project;

@RestController
public class ProjectController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectFacade projectFacade;

	@GetMapping("/projects")
	public ResponseEntity<JSONResponseModel> getProjects(HttpServletRequest request, HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			List<Project> projects = projectFacade.findProjects();

			jsonResponseModel = setJSONResponseVO(projects, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@GetMapping("/projects/{projectId}")
	public ResponseEntity<JSONResponseModel> getProject(@PathVariable String projectId, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			Project project = projectFacade.findProject(new Project(projectId));

			jsonResponseModel = setJSONResponseVO(project, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@PostMapping("/projects")
	public ResponseEntity<JSONResponseModel> createProject(@RequestBody Project project, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			projectFacade.createProject(project);

			jsonResponseModel = setJSONResponseVO(true, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}
	
	@PutMapping("/projects/{projectId}")
	public ResponseEntity<JSONResponseModel> updateProject(@PathVariable String projectId, @RequestBody Project project, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			projectFacade.updateProject(project);

			jsonResponseModel = setJSONResponseVO(true, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

	@DeleteMapping("/projects/{projectId}")
	public ResponseEntity<JSONResponseModel> deleteProject(@PathVariable String projectId, HttpServletRequest request,
			HttpServletResponse response) {

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		try {

			projectFacade.deleteProject(new Project(projectId));

			jsonResponseModel = setJSONResponseVO(true, response);
		} catch (Exception e) {
			jsonResponseModel = setJSONResponseVOFailed(response, ServiceConstants.FAILURE,
					ServiceConstants.EXCEPTIONMSG);
			// TODO: handle exception
		}
		return new ResponseEntity<>(jsonResponseModel, HttpStatus.OK);
	}

}
