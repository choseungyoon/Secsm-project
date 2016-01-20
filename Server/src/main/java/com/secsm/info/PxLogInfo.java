package com.secsm.info;

import java.sql.Timestamp;

public class PxLogInfo {

	private int id;
	private int accountId;
	private int pxItemsId;
	private Timestamp regDate;
	private int type;
	private int count;
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
	public int getPxItemsId() {
		return pxItemsId;
	}
	public void setPxItemsId(int pxItemsId) {
		this.pxItemsId = pxItemsId;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
