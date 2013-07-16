package com.icss.employeeSystem.repository.init;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentRepository {

	private Connection connection;
	
	public DepartmentRepository(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * 根据部门名称获取该部门的id
	 * @param depName
	 * @return	如果没有该部门则返回-1
	 * @throws SQLException 
	 */
	public int getDepartmentIdByName(String depName) throws SQLException {
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery(
				"SELECT depId FROM department WHERE depName='" + depName + "';");
		int id = -1;
		if(result.first()) {
			id = result.getInt("depId");
		}
		result.close();
		state.close();
		return id;
	}
	
	/**
	 * 插入部门
	 * @param depName
	 * @return	插入成功返回该部门的id
	 * @throws SQLException 
	 */
	public int insert(String depName) throws SQLException {
		Statement state = connection.createStatement();
		state.execute("INSERT INTO department(depName) VALUES('" + depName + "');");
		state.close();
		return getDepartmentIdByName(depName);
	}
	
}
