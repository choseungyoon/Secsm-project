package com.secsm.info;

public class PresentationInfo {
	
	private int id;
	private int projectId;
	private int presentationDateId;
	private int PresentationType;
	private String code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getPresentationDateId() {
		return presentationDateId;
	}
	public void setPresentationDateId(int presentationDateId) {
		this.presentationDateId = presentationDateId;
	}
	public int getPresentationType() {
		return PresentationType;
	}
	public void setPresentationType(int presentationType) {
		PresentationType = presentationType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
