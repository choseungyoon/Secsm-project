package com.secsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.secsm.idao.AccountIDao;
import com.secsm.info.AccountInfo;

public class AccountDao implements AccountIDao {
	private static final Logger logger = LoggerFactory.getLogger(AccountDao.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Updated DataSource ---> " + ds);
		logger.info("Updated jdbcTemplate ---> " + jdbcTemplate);
	}

	public List<AccountInfo> selectAll() {
		return jdbcTemplate.query("select * from activity_log", new Object[] {  },
				new RowMapper<AccountInfo>() {
					public AccountInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new AccountInfo(resultSet.getInt("id"), resultSet.getString("project_key"),
								resultSet.getString("name"), resultSet.getString("activity_name"),
								resultSet.getString("activity_name"), resultSet.getInt("activityb_name"));
					}
				});
	}

	public List<AccountInfo> select(String email) {
		return jdbcTemplate.query("select * from activity_log where project_key = ?", new Object[] { email },
				new RowMapper<AccountInfo>() {
					public AccountInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new AccountInfo(resultSet.getInt("id"), resultSet.getString("project_key"),
								resultSet.getString("name"), resultSet.getString("activity_name"),
								resultSet.getString("activity_name"), resultSet.getInt("activityb_name"));
					}
				});
	}
}
