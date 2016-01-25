package com.secsm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.secsm.idao.ProjectIDao;
import com.secsm.info.ProjectInfo;

public class ProjectDao implements ProjectIDao {
	private static final Logger logger = LoggerFactory.getLogger(ProjectDao.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("Updated DataSource ---> " + ds);
		logger.info("Updated jdbcTemplate ---> " + jdbcTemplate);
	}
	
	public List<ProjectInfo> create(String name, String summary, String discription, String pl, String teamMember, Timestamp startDate, Timestamp endDate){
		return jdbcTemplate.query("select * from project", new Object[] {  },
				new RowMapper<ProjectInfo>() {
					public ProjectInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new ProjectInfo(resultSet.getInt("id"), resultSet.getString("name"),
								resultSet.getString("summary"), resultSet.getString("description"),
								resultSet.getString("pl"), resultSet.getString("activityb_name"),
								resultSet.getTimestamp("startDate"), resultSet.getTimestamp("endDate"),
								resultSet.getTimestamp("regDate"));
					}
				});
	}

	public List<ProjectInfo> selectAll(){
		return jdbcTemplate.query("select * from project", new Object[] {  },
				new RowMapper<ProjectInfo>() {
					public ProjectInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new ProjectInfo(resultSet.getInt("id"), resultSet.getString("name"),
								resultSet.getString("summary"), resultSet.getString("description"),
								resultSet.getString("pl"), resultSet.getString("activityb_name"),
								resultSet.getTimestamp("startDate"), resultSet.getTimestamp("endDate"),
								resultSet.getTimestamp("regDate"));
					}
				});
	}
	
	public List<ProjectInfo> select(){
		return jdbcTemplate.query("select * from project", new Object[] {  },
				new RowMapper<ProjectInfo>() {
					public ProjectInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new ProjectInfo(resultSet.getInt("id"), resultSet.getString("name"),
								resultSet.getString("summary"), resultSet.getString("description"),
								resultSet.getString("pl"), resultSet.getString("activityb_name"),
								resultSet.getTimestamp("startDate"), resultSet.getTimestamp("endDate"),
								resultSet.getTimestamp("regDate"));
					}
				});
	}
	
	public void updateProject(int id, String name, String summary, String description, String pl, String teamMember, Timestamp startDate, Timestamp endDate){
		jdbcTemplate.update("update project set "
				+ "name = ?,"
				+ " summary = ?,"
				+ " description = ?,"
				+ " pl = ?,"
				+ " team = ?,"
				+ " startDate = ?,"
				+ " endDate = ?"
			+ " where id = ?", 
			new Object[]  { name, summary, description, pl, teamMember, startDate, endDate , id});
	}
	
	public void delete(int id){
		
	}
	
	
}
