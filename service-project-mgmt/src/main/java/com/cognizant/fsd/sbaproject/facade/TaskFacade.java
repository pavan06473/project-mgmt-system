package com.cognizant.fsd.sbaproject.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.fsd.sbaproject.model.Task;
import com.cognizant.fsd.sbaproject.service.TaskService;

/**
 * SampleFacade 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */


@Component
public class TaskFacade implements BaseFacade {

	Logger logger = LoggerFactory.getLogger(TaskFacade.class);

	@Autowired
	TaskService taskService;

	public void createTask(Task task) {
		taskService.create(task);
	}

	public void updateTask(Task task) {
		taskService.update(task);
	}

	public void deleteTask(Task task) {
		taskService.delete(task);
	}

	public void deleteAllTask() {
		taskService.deleteAll();
	}

	public Task findTask(Task task) {
		return taskService.find(task);
	}
	
	public List<Task> findAll() {
		return taskService.findAll();
	}
}
