package com.secsm.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secsm.command.EquipmentCommand;
import com.secsm.dao.AccountDao;

@Controller
public class EquipmentController {

	EquipmentCommand command = null;
	
	private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);

	@RequestMapping(value = "/equipment", method = RequestMethod.GET)
	public String MainController_equipment_index(HttpServletRequest request) {
		logger.info("equipment Page");

		return "equipment";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String MainController_book_index(HttpServletRequest request, Model model) {
		logger.info("book Page");
		model.addAttribute("request", request);
		command = new EquipmentCommand();
		command.execute_list(model);
		return "book";
	}
	
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String MainController_book_Search(HttpServletRequest request, Model model) {
		logger.info("bookSearch Page");
		
		command =  new EquipmentCommand();
		command.execute_search(model);
		
		return "book";
	}
}	
