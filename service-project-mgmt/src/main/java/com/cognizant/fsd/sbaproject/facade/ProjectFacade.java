package com.cognizant.fsd.sbaproject.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.fsd.sbaproject.model.Project;
import com.cognizant.fsd.sbaproject.service.ProjectService;

/**
 * SampleFacade 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */


@Component
public class ProjectFacade implements BaseFacade {

	Logger logger = LoggerFactory.getLogger(ProjectFacade.class);

	@Autowired
	ProjectService projectService;

	public void createProject(Project project) {
		projectService.create(project);
	}

	public void updateProject(Project project) {
		projectService.update(project);
	}

	public void deleteProject(Project project) {
		projectService.delete(project);
	}

	public void deleteAllProject() {
		projectService.deleteAll();
	}

	public Project findProject(Project project) {
		return projectService.find(project);
	}

	public List<Project> findProjects() {
		return projectService.finAll();
	}
}
