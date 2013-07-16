package com.icss.employeeSystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFactory {
	
	/**
	 * 打开数据库  
	 * @return	打开失败返回null 
	 */
	public static Connection open(
			String DBDriver, String DBConnStr, String user, String password) {
		try {
			Class.forName(DBDriver);
			Connection connection = 
					DriverManager.getConnection(
							DBConnStr, 
							user, 
							password);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 关闭数据库
	 * @param connection	
	 * @return	关闭是否成功
	 */
	public static boolean close(Connection connection) {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
