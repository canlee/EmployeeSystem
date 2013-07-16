package com.icss.employeeSystem.repository.init;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.icss.employeeSystem.model.po.Authority;
import com.icss.employeeSystem.model.po.Employee;

public class EmployeeRepository {

	private Connection connection;
	
	public EmployeeRepository(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * 查询数据库是否有该用户
	 * @param e
	 * @return
	 * @throws SQLException 
	 */
	public boolean hasEmployee(Employee e) throws SQLException {
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery(
				"SELECT * FROM employee WHERE empId='" + e.getEmpId() + "'");
		boolean b = false;
		if(result.first()) {
			b = true;
		}
		result.close();
		state.close();
		return b;
	}
	
	/**
	 * 插入人员
	 * @param e
	 * @throws SQLException 
	 */
	public void insert(Employee e) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("INSERT INTO " +
				"employee(empId, " +
						"postId, " +
						"empName, " +
						"salary, " +
						"password) VALUES('" +
						e.getEmpId() + "', " + 
						e.getPostId() + ", '" + 
						e.getEmpName() + "', " +
						"0, '" + 
						e.getPassword() + "');");
		statement.close();
	}
	
	/**
	 * 使该用户加上所有的权限
	 * @param e
	 * @throws SQLException 
	 */
	public void addAllAuthority(Employee e) throws SQLException {
		AuthorityRepository auResp = new AuthorityRepository(connection);
		List<Authority> allAu = auResp.getAllAuthorities();
		for(Authority au : allAu) {
			Statement state = connection.createStatement();
			state.execute("INSERT INTO employee_authority(authId, empId) " +
					"VALUES(" + au.getAuthorityId() + ", '" + 
					e.getEmpId() + "');");
			state.close();
		}
	}
	
}
