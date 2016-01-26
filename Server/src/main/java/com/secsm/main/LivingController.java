package com.secsm.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LivingController {
	private static final Logger logger = LoggerFactory.getLogger(LivingController.class);
	
	@RequestMapping(value = "/duty", method = RequestMethod.GET)
	public String MainController_duty_index(HttpServletRequest request) {
		logger.info("duty Page");

		return "duty";
	}
	
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String MainController_attendance_index(HttpServletRequest request) {
		logger.info("attendance Page");

		return "attendance";
	}
}
