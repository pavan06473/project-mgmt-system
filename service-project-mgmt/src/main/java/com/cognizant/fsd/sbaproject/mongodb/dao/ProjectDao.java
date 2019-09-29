package com.cognizant.fsd.sbaproject.mongodb.dao;


import java.util.List;

import com.cognizant.fsd.sbaproject.model.Project;

public interface ProjectDao {

	public void create(Project project);

	public void update(Project project);

	public void delete(Project project);

	public void deleteAll();

	public Project find(Project project);

	public List<Project> findAll();

}