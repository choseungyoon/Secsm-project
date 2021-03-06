package com.secsm.info;

import java.sql.Timestamp;

public class AttendanceInfo {

	private int accountId;
	private Timestamp regDate;
	
	public AttendanceInfo(int accountId, Timestamp regDate){
		this.accountId = accountId;
		this.regDate = regDate;
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
}
