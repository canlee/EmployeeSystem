package com.icss.employeeSystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.framework.base.dao.jdbc.JdbcDaoHelper;

@Component("EOArepository")
public class EOARepository {

	@Autowired
	private JdbcDaoHelper jdbcDaoHelper;
	
	public EOARepository() {
		// TODO Auto-generated constructor stub
	}

	public JdbcDaoHelper getJdbcDaoHelper() {
		return jdbcDaoHelper;
	}

	public void setJdbcDaoHelper(JdbcDaoHelper jdbcDaoHelper) {
		this.jdbcDaoHelper = jdbcDaoHelper;
	}
	
	public void insert(String empId,String authId){
		jdbcDaoHelper.getJdbcTemplate().execute("insert into employee_authority values(\""+authId+"\",\""+empId+"\")");
	}
	
	public void deleteWithEmpId(String empId){
		jdbcDaoHelper.getJdbcTemplate().execute("delete from employee_authority where empId = "+empId);
	}
	
	public List<?> queryForList(final String sql, final List<?> paras){
		return jdbcDaoHelper.queryForList(sql, paras);
	}
}
