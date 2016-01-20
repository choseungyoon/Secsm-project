package com.secsm.info;

import java.sql.Timestamp;

public class DutyInfo {

	private int id;
	private Timestamp dutyDate;
	private int accountId1;
	private int accountId2;
	private int accountId3;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDutyDate() {
		return dutyDate;
	}
	public void setDutyDate(Timestamp dutyDate) {
		this.dutyDate = dutyDate;
	}
	public int getAccountId1() {
		return accountId1;
	}
	public void setAccountId1(int accountId1) {
		this.accountId1 = accountId1;
	}
	public int getAccountId2() {
		return accountId2;
	}
	public void setAccountId2(int accountId2) {
		this.accountId2 = accountId2;
	}
	public int getAccountId3() {
		return accountId3;
	}
	public void setAccountId3(int accountId3) {
		this.accountId3 = accountId3;
	}
}
