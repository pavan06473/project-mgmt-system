package com.cognizant.fsd.sbaproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projecttask")
public class ParentTask {

	@Id
	private String parentId;
	private String parentTask;

	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public ParentTask() {
		super();
	}
	public ParentTask(String parentId) {
		super();
		this.parentId = parentId;
	}
	
	
}
