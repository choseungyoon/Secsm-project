package com.secsm.info;

import java.sql.Timestamp;

public class EquipmentItemsInfo {

	private int id;
	private String code;
	private String name;
	private int type;
	private Timestamp regDate;
	private int count;
	private int statute;
	private String description;
	
	public  EquipmentItemsInfo(){
		
	}
	
	public EquipmentItemsInfo(int id, String code, String name, int type, Timestamp regDate, int count, int statute,
			String description) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.type = type;
		this.regDate = regDate;
		this.count = count;
		this.statute = statute;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatute() {
		return statute;
	}
	public void setStatute(int status) {
		this.statute = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
