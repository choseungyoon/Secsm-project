package com.secsm.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secsm.command.EquipmentCommand;
import com.secsm.util.Constant;

@Controller
public class EquipmentController {

	
	
	EquipmentCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);

	@RequestMapping(value = "/equipment", method = RequestMethod.GET)
	public String MainController_equipment_index(HttpServletRequest request,Model model) {
		logger.info("equipment Page");
		
		command = new EquipmentCommand();
		command.execute_list(model,1);
		
		return "equipment";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String MainController_book_index(Model model) {
		logger.info("book Page");
		
		//Book List View
		command = new EquipmentCommand();
		command.execute_list(model,0);
		return "book";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		logger.info("content_view");
		
		model.addAttribute("request", request);
		command = new EquipmentCommand();
		command.Content_view(model);
		
		return "contentview";
	}
	
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String MainController_book_Search(HttpServletRequest request, Model model) {
		logger.info("bookSearch Page");
		
		command =  new EquipmentCommand();
		command.execute_search(model);
		
		return "book";
	}
}	
