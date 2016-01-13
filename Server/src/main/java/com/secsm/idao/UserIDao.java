package com.secsm.idao;

import java.util.List;

import javax.sql.DataSource;

public interface UserIDao {
	void setDataSource(DataSource ds);
	
	void create(String project_key, String name);
	void appCountInc(String project_key, String name);
	void setGCM(String project_key, String name, String gcm_id);
	void setGradeTime(String project_key, String name, int grage_time);
	void setGradeMoney(String project_key, String name, int grage_money);
	void setPosition(String project_key, String name, double position_let, double position_lon, String location);
	void setOsVersion(String project_key, String name, String os_version);
	void setDevice(String project_key, String name, String device_vertion);
	void setAge(String project_key, String name, int age);
	void setSex(String project_key, String name, int sex);
	void setGCMId(String project_key, String name, String gcm_id);
	
	void getVirtual_main(String project_key, String name, int money);
	void useVirtual_main(String project_key, String name, int money);
	
	void getVirtual_sub(String project_key, String name, int money);
	void useVirtual_sub(String project_key, String name, int money);
	
	void deleteAll();
	void delete(String project_key);
}
