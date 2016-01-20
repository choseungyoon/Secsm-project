package com.secsm.info;

import java.sql.Timestamp;

public class PresentationDateInfo {

	private int id;
	private Timestamp presentationDate;
	private int isFirst;
	private int isSecond;
	private int isThird;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getPresentationDate() {
		return presentationDate;
	}
	public void setPresentationDate(Timestamp presentationDate) {
		this.presentationDate = presentationDate;
	}
	public int getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(int isFirst) {
		this.isFirst = isFirst;
	}
	public int getIsSecond() {
		return isSecond;
	}
	public void setIsSecond(int isSecond) {
		this.isSecond = isSecond;
	}
	public int getIsThird() {
		return isThird;
	}
	public void setIsThird(int isThird) {
		this.isThird = isThird;
	}
}
