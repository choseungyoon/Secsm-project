package com.secsm.command;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.secsm.dao.EquipmentItemsDao;
import com.secsm.info.EquipmentItemsInfo;
import com.secsm.main.EquipmentController;

public class EquipmentCommand {
	
	
	private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);
	
	public void execute_search(Model model){
		
	}
	
	public void execute_list(Model model){
		logger.info("equipment_list Page");
		EquipmentItemsDao dao = new EquipmentItemsDao();
//		List<EquipmentItemsInfo> equipItemInfo = dao.list();
//		model.addAttribute("list",equipItemInfo);
	}
}
