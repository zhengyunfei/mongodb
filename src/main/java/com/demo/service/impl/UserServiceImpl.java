package com.demo.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.demo.pojo.User;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private static String USER_COLLECTION = "user";
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveUser(User user) {
		mongoTemplate.save(user,USER_COLLECTION);
	}
	
	public User findUser(String name) {
//		if (mongoTemplate == null)
//			return null;
		Query query = new Query(Criteria.where("name").is(name));
		User user = mongoTemplate.findOne(query, User.class,USER_COLLECTION);
		if (user == null)
			return null;
		logger.info("查询用户：{}",user.toString());
		return user;
	}

}
