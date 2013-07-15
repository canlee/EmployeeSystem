package com.icss.employeeSystem.repository.init;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icss.employeeSystem.model.po.Authority;

public class AuthorityRepository {

	private Connection connection;
	
	public AuthorityRepository(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * 获取数据库中所有的权限
	 * @return	没有则返回空的list，获取失败返回null
	 * @throws SQLException 
	 */
	public List<Authority> getAllAuthorities() throws SQLException {
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM authority;");
		List<Authority> allAu = new ArrayList<Authority>();
		if(result.first()) {
			do {
				Authority au = new Authority();
				au.setAuthorityId(result.getInt("authorityId"));
				au.setAuthorityName(result.getString("authorityName"));
				allAu.add(au);
			} while(result.next());
		}
		state.close();
		result.close();
		return allAu;
	}
	
	/**
	 * 删除权限
	 * @param au
	 * @throws SQLException
	 */
	public void delete(Authority au) throws SQLException {
		Statement state = connection.createStatement();
		state.execute(
				"DELETE FROM authority WHERE authorityId=" + 
				au.getAuthorityId() + ";");
		state.close();
		state = connection.createStatement();
		state.execute("DELETE FROM employee_authority WHERE authorityId=" +
				au.getAuthorityId() + ";");
		state.close();
	}
	
	/**
	 * 在数据库中添加权限
	 * @param au
	 * @throws SQLException 
	 */
	public void insert(Authority au) throws SQLException {
		Statement state = connection.createStatement();
		state.execute("INSERT INTO authority(authorityId, authorityName) " +
				"VALUES(" + au.getAuthorityId() + ", '" + 
				au.getAuthorityName() + "');");
		state.close();
	}
	
}
