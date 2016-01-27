package com.secsm.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.secsm.dao.ProjectDao;

@Controller
public class ProjectApi {
	private static final Logger logger = LoggerFactory.getLogger(ProjectApi.class);
	
	@Autowired
	private ProjectDao projectDao;
	
	/** 교육 Main */
	@RequestMapping(value = "/api_createProject", method = RequestMethod.POST)
	public String ProjectController_index(HttpServletRequest request
			, @RequestParam("createProjectName") String name
 			, @RequestParam("createProjectSummary") String summary
 			, @RequestParam("createProjectDiscription") String discription
 			, @RequestParam("createProjectPL") String pl
 			, @RequestParam("createProjectPL") String teamMember
 			, @RequestParam("createProjectStartDate") String startDate
 			, @RequestParam("createProjectEndDate") String endDate) {
		logger.info("api_createProject");

		request.setAttribute("projectList", projectDao.selectAll());
		return "project";
	}
}
