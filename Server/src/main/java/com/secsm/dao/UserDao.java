package com.secsm.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secsm.idao.UserIDao;

@Repository
public class UserDao implements UserIDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Updated DataSource ---> " + ds);
		logger.info("Updated jdbcTemplate ---> " + jdbcTemplate);
	}

	public void create(String project_key, String name) {
		logger.info("UserDao<create> project_key: " + project_key + ", name: " + name);
		jdbcTemplate.update("insert into user (project_key, name) values (?, ?)", new Object[] { project_key, name });
	}

	public void appCountInc(String project_key, String name) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " count = count + 1" + " where project_key = ? AND name = ?",
				new Object[] { project_key, name });
	}

	public void setGCM(String project_key, String name, String gcm_id) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " gcm_id = ?" + " where project_key = ? AND name = ?",
				new Object[] { gcm_id, project_key, name });
	}

	public void setGradeTime(String project_key, String name, int grade_time) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " grade_time = ?" + " where project_key = ? AND name = ?",
				new Object[] { grade_time, project_key, name });
	}

	public void setGradeMoney(String project_key, String name, int grade_money) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " grade_money = ?" + " where project_key = ? AND name = ?",
				new Object[] { grade_money, project_key, name });
	}

	public void setPosition(String project_key, String name, double position_let, double position_lon, String location) {
		isExist(project_key, name);
		jdbcTemplate.update(
				"update user set " + " position_let = ?," + " position_lon = ?, location = ?" + " where project_key = ? AND name = ?",
				new Object[] { position_let, position_lon, location, project_key, name });
	}

	public void setOsVersion(String project_key, String name, String os_version) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " os_version = ?" + " where project_key = ? AND name = ?",
				new Object[] { os_version, project_key, name });
	}

	public void setDevice(String project_key, String name, String device_version) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " device_version = ?" + " where project_key = ? AND name = ?",
				new Object[] { device_version, project_key, name });
	}

	public void setAge(String project_key, String name, int age) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " age = ?" + " where project_key = ? AND name = ?",
				new Object[] { age, project_key, name });
	}

	public void setSex(String project_key, String name, int sex) {
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " sex = ?" + " where project_key = ? AND name = ?",
				new Object[] { sex, project_key, name });
	}

	public void setGCMId(String project_key, String name, String gcm_id) {
		isExist(project_key, name);
		isExist(project_key, name);
		jdbcTemplate.update("update user set " + " gcm_id = ?" + " where project_key = ? AND name = ?",
				new Object[] { gcm_id, project_key, name });
	}

	public void getVirtual_main(String project_key, String name, int money) {
		isExist(project_key, name);
		jdbcTemplate.update(
				"update user set " + " virtual_main = virtual_main + " + money + " where project_key = ? AND name = ?",
				new Object[] { project_key, name });
	}

	public void useVirtual_main(String project_key, String name, int money) {
		isExist(project_key, name);
		jdbcTemplate.update(
				"update user set " + " virtual_main = virtual_main - " + money + " where project_key = ? AND name = ?",
				new Object[] { project_key, name });
	}

	public void getVirtual_sub(String project_key, String name, int money) {
		isExist(project_key, name);
		jdbcTemplate.update(
				"update user set " + " virtual_sub = virtual_sub + " + money + " where project_key = ? AND name = ?",
				new Object[] { project_key, name });
	}

	public void useVirtual_sub(String project_key, String name, int money) {
		isExist(project_key, name);
		jdbcTemplate.update(
				"update user set " + " virtual_sub = virtual_sub - " + money + " where project_key = ? AND name = ?",
				new Object[] { project_key, name });
	}

	public void deleteAll() {
		jdbcTemplate.update("delete from user");
	}

	public void delete(String project_key) {
		jdbcTemplate.update("delete from user where project_key = ?", new Object[] { project_key });
	}

	private void isExist(String project_key, String name) {
		logger.info("UserDao<isExist>");
	}
}
