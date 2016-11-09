package com.demo.controller;

import com.demo.pojo.OperationLog;
import com.demo.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/log")
public class OperationLogController {

	@Autowired
	private OperationLogService operationLogService;

	@RequestMapping("/index")
	public ModelAndView index () {
		return new ModelAndView("index");
	}


	@RequestMapping("/save")
	public void save (OperationLog log) {
		operationLogService.save(log);
	}

	@RequestMapping("/find")
	public ModelAndView find (String mobile) {
		OperationLog log = operationLogService.find(mobile);
		ModelAndView mv=new ModelAndView();
		mv.addObject("log",log);
		return mv;
	}

}
