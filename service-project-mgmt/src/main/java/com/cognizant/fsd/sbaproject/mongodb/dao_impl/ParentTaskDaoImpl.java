package com.cognizant.fsd.sbaproject.mongodb.dao_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.fsd.sbaproject.model.ParentTask;
import com.cognizant.fsd.sbaproject.mongodb.dao.ParentTaskDao;

@Repository
@Qualifier("ParentTaskDao")
public class ParentTaskDaoImpl implements ParentTaskDao {

	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "parenttask";

	public void create(ParentTask parentTask) {
		mongoTemplate.insert(parentTask);
	}

	public void update(ParentTask parentTask) {
		mongoTemplate.save(parentTask);
	}

	public void delete(ParentTask parentTask) {
		mongoTemplate.remove(parentTask);
	}

	public void deleteAll() {
		mongoTemplate.remove(new Query(), COLLECTION);
	}

	public ParentTask find(ParentTask parentTask) {
		Query query = new Query(Criteria.where("_id").is(parentTask.getParentId()));
		return mongoTemplate.findOne(query, ParentTask.class);
	}
}