package com.cognizant.fsd.sbaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fsd.sbaproject.model.Project;
import com.cognizant.fsd.sbaproject.mongodb.dao.ProjectDao;


@Service("ProjectService")
public class ProjectService {

	@Autowired
	ProjectDao projectDao;

	public void create(Project project) {
		projectDao.create(project);
	}

	public void update(Project project) {
		projectDao.update(project);
	}

	public void delete(Project project) {
		projectDao.delete(project);
	}

	public void deleteAll() {
		projectDao.deleteAll();
	}

	public Project find(Project project) {
		return projectDao.find(project);
	}
}