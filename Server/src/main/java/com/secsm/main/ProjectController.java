package com.secsm.main;

import java.sql.Timestamp;

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
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectDao projectDao;
	
	/** 교육 Main */
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String ProjectController_project_index(HttpServletRequest request) {
		logger.info("project Page");

		request.setAttribute("projectList", projectDao.selectAll());
		return "project";
	}
	
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String ProjectController_add(HttpServletRequest request
			, @RequestParam("name") String name
 			, @RequestParam("summary") String summary
 			, @RequestParam("discription") String discription
 			, @RequestParam("PL") String pl
 			, @RequestParam("teamMember") String teamMember
 			, @RequestParam("startDate") String startDate
 			, @RequestParam("endDate") String endDate) {
		logger.info("addProject Page");

		Timestamp startDate_ = Timestamp.valueOf(startDate);
		Timestamp endDate_ = Timestamp.valueOf(endDate);
		
		projectDao.create(name, summary, discription, pl, teamMember, startDate_, endDate_);
		
		return "addProject";
	}
	
	@RequestMapping(value = "/updateProject", method = RequestMethod.POST)
	public String ProjectController_update(HttpServletRequest request
			, @RequestParam("id") int id
 			, @RequestParam("name") String name
 			, @RequestParam("summary") String summary
 			, @RequestParam("discription") String discription
 			, @RequestParam("PL") String pl
 			, @RequestParam("teamMember") String teamMember
 			, @RequestParam("startDate") String startDate
 			, @RequestParam("endDate") String endDate) {
		logger.info("updateProject Page");

		return "updateProject";
	}
	
	@RequestMapping(value = "/detailProject", method = RequestMethod.GET)
	public String ProjectController_detail(HttpServletRequest request
			, @RequestParam("id") int id) {
		logger.info("detailProject Page");

		projectDao.delete(id);
		
		return "detailProject";
	}
	
}
