package com.secsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
	
	//book or equipment list view
	public ArrayList<EquipmentItemsInfo> list(int type) {
		ArrayList<EquipmentItemsInfo> result = null;
		String query = null;
		if(type == 0){
			query = "select id, name, type,count,statute ,description from equipment_items where type = 0";
		}
		else if(type ==1){
			query = "select id, name, type,count,statute ,description from equipment_items where type = 1";	
		}
		
		result = (ArrayList<EquipmentItemsInfo>)jdbcTemplate.query(query, new BeanPropertyRowMapper<EquipmentItemsInfo>(EquipmentItemsInfo.class));
		return result;
	}
	
	//Content detail view
	
	public EquipmentItemsInfo contentView(String id){
		String query = "select * from equipment_items where id = " + id;
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<EquipmentItemsInfo>(EquipmentItemsInfo.class));
	}
	
	public void delete(int id){
		jdbcTemplate.update("delete from duty where id = ?", new Object[id]);
	}
	
	public void deleteAll(){
		jdbcTemplate.update("delete from duty");
	}
}
