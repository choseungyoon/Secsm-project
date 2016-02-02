package com.secsm.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.secsm.dao.EquipmentItemsDao;
import com.secsm.info.EquipmentItemsInfo;

public class EquipmentCommand {
	
	
	private static final Logger logger = LoggerFactory.getLogger(EquipmentCommand.class);
	
	public void execute_search(Model model){
		
	}
	
	public void execute_list(Model model,int type){
		
		logger.info("equipment_list Page");
		EquipmentItemsDao dao = new EquipmentItemsDao();
		if(type == 0 ){
			ArrayList<EquipmentItemsInfo> equipItemInfo = dao.list(0);
			model.addAttribute("list",equipItemInfo);
		}
		else if(type == 1){
			ArrayList<EquipmentItemsInfo> equipItemInfo = dao.list(1);
			model.addAttribute("list",equipItemInfo);
		}
	}
	
	public void Content_view(Model model){
		logger.info("equipment_content view");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		
		EquipmentItemsDao dao = new EquipmentItemsDao();
		System.out.println(id);
		EquipmentItemsInfo dto = dao.contentView(id);
	
		model.addAttribute("content_view",dto);
	}
}
