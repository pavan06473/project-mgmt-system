package com.cognizant.fsd.sbaproject.mongodb.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.fsd.sbaproject.model.Project;
import com.cognizant.fsd.sbaproject.mongodb.dao.ProjectDao;

@Repository
@Qualifier("ProjectDao")
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "project";

	public void create(Project project) {
		mongoTemplate.insert(project);
	}

	public void update(Project project) {
		mongoTemplate.save(project);
	}

	public void delete(Project project) {
		mongoTemplate.remove(project);
	}

	public void deleteAll() {
		mongoTemplate.remove(new Query(), COLLECTION);
	}

	public Project find(Project project) {
		Query query = new Query(Criteria.where("_id").is(project.getProjectId()));
		return mongoTemplate.findOne(query, Project.class);
	}

	public List<Project> findAll() {
		return mongoTemplate.findAll(Project.class);
	}
}