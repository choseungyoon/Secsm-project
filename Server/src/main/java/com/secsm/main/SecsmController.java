package com.secsm.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secsm.dao.UserDao;

@Controller
public class SecsmController {
	private static final Logger logger = LoggerFactory.getLogger(SecsmController.class);

//	@Autowired
//	private UserDao userDao;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String MainController_index(HttpServletRequest request) {
		logger.info("index Page");

		return "index";
	}
}
