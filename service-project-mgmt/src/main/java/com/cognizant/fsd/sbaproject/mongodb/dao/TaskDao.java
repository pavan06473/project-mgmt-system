package com.cognizant.fsd.sbaproject.mongodb.dao;


import java.util.List;

import com.cognizant.fsd.sbaproject.model.Task;

public interface TaskDao {

	public void create(Task task);

	public void update(Task task);

	public void delete(Task task);

	public void deleteAll();

	public Task find(Task task);
	
	public List<Task> findAll();

}