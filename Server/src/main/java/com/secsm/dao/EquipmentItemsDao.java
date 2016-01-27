package com.secsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.secsm.idao.EquipmentItemsIDao;
import com.secsm.info.DutyInfo;
import com.secsm.info.EquipmentItemsInfo;

public class EquipmentItemsDao implements EquipmentItemsIDao {
	private static final Logger logger = LoggerFactory.getLogger(EquipmentItemsDao.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Updated DataSource ---> " + ds);
		logger.info("Updated jdbcTemplate ---> " + jdbcTemplate);
	}

	public void create(){
		jdbcTemplate.update("insert info equipment_items (dutyDate, accountId1, accountId2, accountId3)");
	}
	
	public List<EquipmentItemsInfo> selectAll(){
		return jdbcTemplate.query("select * from duty",
				new RowMapper<EquipmentItemsInfo>() {
					public EquipmentItemsInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new EquipmentItemsInfo(resultSet.getInt("id"), resultSet.getString("dytyDate")
								, resultSet.getInt("accountId1"), resultSet.getInt("accountId2")
								, resultSet.getInt("accountId3"));
					}
				});
	}
	
	public List<DutyInfo> select(){
		
	}
	
	public void delete(){
		
	}
	
	public void deleteAll(){
		
	}
}
