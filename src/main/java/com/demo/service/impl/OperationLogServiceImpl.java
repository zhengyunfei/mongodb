package com.demo.service.impl;


import com.demo.pojo.OperationLog;
import com.demo.service.OperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl implements OperationLogService{
	private final static Logger logger = LoggerFactory.getLogger(OperationLogServiceImpl.class);
	private static String OPERATION_LOGIN_COLLECTION = "log";

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(OperationLog operationLog) {
		mongoTemplate.save(operationLog,OPERATION_LOGIN_COLLECTION);
	}

	public OperationLog find(String mobile) {
//		if (mongoTemplate == null)
//			return null;
		Query query = new Query(Criteria.where("mobile").is(mobile));
		OperationLog log = mongoTemplate.findOne(query, OperationLog.class,OPERATION_LOGIN_COLLECTION);
		if (log == null)
			return null;
		logger.info("查询日志：{}",log.toString());
		return log;
	}

}
