package com.icss.employeeSystem.repository.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.framework.base.dao.jdbc.JdbcDaoHelper;

@Component("applyRepository")
public class ApplyRepository {

	@Autowired
	private JdbcDaoHelper jdbcDaoHelper;

	public JdbcDaoHelper getJdbcDaoHelper() {
		return jdbcDaoHelper;
	}

	public void setJdbcDaoHelper(JdbcDaoHelper jdbcDaoHelper) {
		this.jdbcDaoHelper = jdbcDaoHelper;
	}
	
	public List<?> queryForList(final String sql, final List<?> paras){
		return jdbcDaoHelper.queryForList(sql, paras);
	}
}
