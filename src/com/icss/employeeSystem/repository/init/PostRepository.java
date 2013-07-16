package com.icss.employeeSystem.repository.init;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostRepository {

	private Connection connection;
	
	public PostRepository(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * 根据岗位名称和部门id获取岗位的id
	 * @param postName
	 * @param depId
	 * @return	如果没有该岗位id则返回-1
	 * @throws SQLException 
	 */
	public int getPostId(String postName, int depId) throws SQLException {
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery(
				"SELECT postId FROM post WHERE postName='" + postName + 
				"' AND depId=" + depId + ";");
		int id = -1;
		if(result.first()) {
			id = result.getInt("postId");
		}
		result.close();
		state.close();
		return id;
	}
	
	/**
	 * 插入岗位名和相应的部门id
	 * @param postName
	 * @param depId
	 * @return	插入成功返回该岗位的id
	 * @throws SQLException 
	 */
	public int insert(String postName, int depId) throws SQLException {
		Statement state = connection.createStatement();
		state.execute("INSERT INTO post(postName, depId) VALUES('" + 
				postName + "', " + depId + ");");
		state.close();
		return getPostId(postName, depId);
	}
	
}
