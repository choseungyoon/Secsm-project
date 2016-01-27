package com.secsm.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secsm.info.DutyInfo;

@Repository
public class QuestionDao {
	private static final Logger logger = LoggerFactory.getLogger(QuestionDao.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Updated DataSource ---> " + ds);
		logger.info("Updated jdbcTemplate ---> " + jdbcTemplate);
	}

	public void create(){
		
	}
	
	public List<DutyInfo> selectAll(){
		
	}
	
	public List<DutyInfo> select(){
		
	}
	
	public void delete(){
		
	}
	
	public void deleteAll(){
		
	}
}
