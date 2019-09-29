package com.cognizant.fsd.sbaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fsd.sbaproject.model.ParentTask;
import com.cognizant.fsd.sbaproject.mongodb.dao.ParentTaskDao;


@Service("ParentTaskService")
public class ParentTaskService {

	@Autowired
	ParentTaskDao parentTaskDao;

	public void create(ParentTask parentTask) {
		parentTaskDao.create(parentTask);
	}

	public void update(ParentTask parentTask) {
		parentTaskDao.update(parentTask);
	}

	public void delete(ParentTask parentTask) {
		parentTaskDao.delete(parentTask);
	}

	public void deleteAll() {
		parentTaskDao.deleteAll();
	}

	public ParentTask find(ParentTask parentTask) {
		return parentTaskDao.find(parentTask);
	}
}