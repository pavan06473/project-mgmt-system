package com.cognizant.fsd.sbaproject.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.fsd.sbaproject.model.ParentTask;
import com.cognizant.fsd.sbaproject.service.ParentTaskService;

/**
 * SampleFacade 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */


@Component
public class ParentTaskFacade implements BaseFacade {

	Logger logger = LoggerFactory.getLogger(ParentTaskFacade.class);

	@Autowired
	ParentTaskService parentTaskService;

	public void createParentTask(ParentTask parentTask) {
		parentTaskService.create(parentTask);
	}

	public void updateParentTask(ParentTask parentTask) {
		parentTaskService.update(parentTask);
	}

	public void deleteParentTask(ParentTask parentTask) {
		parentTaskService.delete(parentTask);
	}

	public void deleteAllParentTask() {
		parentTaskService.deleteAll();
	}

	public ParentTask findParentTask(ParentTask parentTask) {
		return parentTaskService.find(parentTask);
	}
}
