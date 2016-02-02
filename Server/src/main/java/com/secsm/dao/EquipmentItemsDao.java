package com.secsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.secsm.idao.EquipmentItemsIDao;
import com.secsm.info.DutyInfo;
import com.secsm.info.EquipmentItemsInfo;
import com.secsm.util.Constant;

public class EquipmentItemsDao implements EquipmentItemsIDao {
	private static final Logger logger = LoggerFactory.getLogger(EquipmentItemsDao.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public EquipmentItemsDao(){
		jdbcTemplate = Constant.template;
	}
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Updated DataSource ---> " + ds);
		logger.info("Updated jdbcTemplate ---> " + jdbcTemplate);
	}

	public void create(){
		jdbcTemplate.update("insert info duty (dutyDate, accountId1, accountId2, accountId3)");
	}
	
	public List<DutyInfo> selectAll(){
		return jdbcTemplate.query("select * from duty",
				new RowMapper<DutyInfo>() {
					public DutyInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new DutyInfo(resultSet.getInt("id"), resultSet.getTimestamp("dytyDate")
								, resultSet.getInt("accountId1"), resultSet.getInt("accountId2")
								, resultSet.getInt("accountId3"));
					}
				});
	}
	
	public List<DutyInfo> select(int id){
		return jdbcTemplate.query("select * from duty where id = ?", new Object[id],
				new RowMapper<DutyInfo>() {
					public DutyInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new DutyInfo(resultSet.getInt("id"), resultSet.getTimestamp("dytyDate")
								, resultSet.getInt("accountId1"), resultSet.getInt("accountId2")
								, resultSet.getInt("accountId3"));
					}
				});
	}
	
	// TODO 날짜 Where 문 채우
	public List<DutyInfo> select(Timestamp date){
		return jdbcTemplate.query("select * from duty where dutyDate = ?",
				new RowMapper<DutyInfo>() {
					public DutyInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new DutyInfo(resultSet.getInt("id"), resultSet.getTimestamp("dytyDate")
								, resultSet.getInt("accountId1"), resultSet.getInt("accountId2")
								, resultSet.getInt("accountId3"));
					}
				});
	}
	
	public List<EquipmentItemsInfo> list() {
		
		String query = "select ID, Name, Type,Count,Statute ,Description from equipment_items";
		List<EquipmentItemsInfo> result = (List<EquipmentItemsInfo>)jdbcTemplate.query(query, new BeanPropertyRowMapper<EquipmentItemsInfo>(EquipmentItemsInfo.class));
		return result;
	}
	
	public void delete(int id){
		jdbcTemplate.update("delete from duty where id = ?", new Object[id]);
	}
	
	public void deleteAll(){
		jdbcTemplate.update("delete from duty");
	}
}
