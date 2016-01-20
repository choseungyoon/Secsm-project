package com.secsm.info;

import java.sql.Timestamp;

public class EquipmentLogInfo {

	private int id;
	private int accountId;
	private Timestamp regDate;
	private int type;
	private int equipmentItemsId;
	private Timestamp startDate;
	private Timestamp endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getEquipmentItemsId() {
		return equipmentItemsId;
	}
	public void setEquipmentItemsId(int equipmentItemsId) {
		this.equipmentItemsId = equipmentItemsId;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	
}
