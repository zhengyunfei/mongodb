package com.demo.controller;

import com.demo.pojo.OperationLog;
import com.demo.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/operationLog")
public class OperationLogApi {

	@Autowired
	private OperationLogService operationLogService;
	/**
	 * mongodb入库api接口
	 * @param log
	 */
	@RequestMapping(value = "/save",method= RequestMethod.POST)
	public void insert (@RequestBody OperationLog log) {
		operationLogService.save(log);
	}
	/**
	 * mongodb入库api接口
	 * @param log
	 */
	@RequestMapping(value = "/new",method= RequestMethod.GET)
	@ResponseBody
	public void insertForGet (@RequestParam String content,@RequestParam String createTime,@RequestParam String ip,@RequestParam String mobile,@RequestParam  String identity) {
		OperationLog log=new OperationLog();
		log.setContent(content);
		log.setCreateTime(createTime);
		log.setIp(ip);
		log.setMobile(mobile);
		log.setIdentity(identity);
		operationLogService.save(log);
	}

	@RequestMapping(value = "/test",method= RequestMethod.POST)
	public void test (@RequestParam String content, @RequestParam String createTime,@RequestParam String ip,@RequestParam String mobile, @RequestParam String identity) {
		OperationLog log=new OperationLog();
		log.setContent(content);
		log.setCreateTime(createTime);
		log.setIp(ip);
		log.setMobile(mobile);
		log.setIdentity(identity);
		operationLogService.save(log);
	}
	@RequestMapping(value="/test2",method=RequestMethod.POST,consumes = "application/json")
	public @ResponseBody
	Map<String, Object> testPostJson(@RequestBody  OperationLog userForm, BindingResult bindingResult) {

		Map<String, Object> map = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			map.put("errorCode", "40001");
			map.put("errorMsg", bindingResult.getFieldError().getDefaultMessage());
		}

		map.put("user", userForm);
		return map;
	}
}
