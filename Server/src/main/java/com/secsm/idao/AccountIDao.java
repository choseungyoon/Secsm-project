package com.secsm.idao;


import java.util.List;

import javax.sql.DataSource;

import com.secsm.info.AccountInfo;

public interface AccountIDao {
	void setDataSource(DataSource ds);
	public List<AccountInfo> selectAll();
	public List<AccountInfo> select(String email);
}
