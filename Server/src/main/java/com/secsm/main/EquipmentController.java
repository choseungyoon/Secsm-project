package com.secsm.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secsm.dao.AccountDao;

@Controller
public class EquipmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);

	@RequestMapping(value = "/equipment", method = RequestMethod.GET)
	public String MainController_index(HttpServletRequest request) {
		logger.info("equipment Page");

		return "equipment";
	}
}	
