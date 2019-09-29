package com.cognizant.fsd.sbaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fsd.sbaproject.model.Task;
import com.cognizant.fsd.sbaproject.mongodb.dao.TaskDao;


@Service("TaskService")
public class TaskService {

	@Autowired
	TaskDao taskDao;

	public void create(Task task) {
		taskDao.create(task);
	}

	public void update(Task task) {
		taskDao.update(task);
	}

	public void delete(Task task) {
		taskDao.delete(task);
	}

	public void deleteAll() {
		taskDao.deleteAll();
	}

	public Task find(Task task) {
		return taskDao.find(task);
	}
	
	public List<Task> findAll() {
		return taskDao.findAll();
	}
}