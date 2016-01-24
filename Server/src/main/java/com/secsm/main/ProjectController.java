package com.secsm.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	/** 교육 Main */
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String MainController_index(HttpServletRequest request) {
		logger.info("project Page");

		return "project";
	}
	
	/** 프로젝트 등록 */
	@RequestMapping(value = "/project/add", method = RequestMethod.GET)
	public String MainController_newProject(HttpServletRequest request) {
		logger.info("project add Page");

		return "ProjectAdd";
	}
	
	/** 프로젝트 수정 */
	@RequestMapping(value = "/project/update", method = RequestMethod.GET)
	public String MainController_updateProject(HttpServletRequest request) {
		logger.info("project update Page");

		return "ProjectUpdate";
	}
}
