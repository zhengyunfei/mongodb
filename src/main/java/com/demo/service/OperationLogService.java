package com.demo.service;

import com.demo.pojo.OperationLog;

public interface OperationLogService {
	/**
	 * 插入日志
	 * @param user
	 * @return
	 */
	void save(OperationLog user);

	/**
	 * 查询日志
	 * @return
	 */
	OperationLog find(String name);
}
