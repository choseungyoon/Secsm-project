package com.secsm.info;

import java.sql.Timestamp;

public class ProjectInfo {

	private int id;
	private Timestamp startDate;
	private Timestamp endDate;
	private String pl;
	private String team1;
	private String team2;
	private String team3;
	private String team4;
	private String name;
	private String summary;
	private String description;
	private Timestamp regDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPl() {
		return pl;
	}
	public void setPl(String pl) {
		this.pl = pl;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTeam3() {
		return team3;
	}
	public void setTeam3(String team3) {
		this.team3 = team3;
	}
	public String getTeam4() {
		return team4;
	}
	public void setTeam4(String team4) {
		this.team4 = team4;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
	
}
