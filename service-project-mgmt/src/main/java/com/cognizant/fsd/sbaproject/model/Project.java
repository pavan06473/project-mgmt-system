package com.cognizant.fsd.sbaproject.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project")
public class Project {

	@Id
	private String projectId;

	private String project;
	private Date startDate;
	private Date endDate;
	private Integer priority;

	private List<String> managerList;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public List<String> getManagerList() {
		return managerList;
	}
	public void setManagerList(List<String> managerList) {
		this.managerList = managerList;
	}
	public Project() {
		super();
	}
	public Project(String projectId) {
		super();
		this.projectId = projectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}



}
