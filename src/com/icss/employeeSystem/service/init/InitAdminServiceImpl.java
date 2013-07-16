package com.icss.employeeSystem.service.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.repository.init.DepartmentRepository;
import com.icss.employeeSystem.repository.init.EmployeeRepository;
import com.icss.employeeSystem.repository.init.PostRepository;

public class InitAdminServiceImpl implements InitAdminService {

	private static final String ADMIN_DEP = "管理部";
	
	private static final String ADMIN_POST = "管理员";
	
	private Connection connection;
	
	public InitAdminServiceImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void initAdmin(String configPath) {
		DepartmentRepository depResp = new DepartmentRepository(connection);
		PostRepository postResp = new PostRepository(connection);
		EmployeeRepository empResp = new EmployeeRepository(connection);
		List<Employee> emps = getRootUser(configPath);
		try {
			connection.setAutoCommit(false);
			int depId = depResp.getDepartmentIdByName(ADMIN_DEP);
			if(depId == -1) {
				depId = depResp.insert(ADMIN_DEP);
			}
			int postId = postResp.getPostId(ADMIN_POST, depId);
			if(postId == -1) {
				postId = postResp.insert(ADMIN_POST, depId);
			}
			for(Employee e : emps) {
				if(!empResp.hasEmployee(e)) {
					e.setPostId(postId);
					empResp.insert(e);
					empResp.addAllAuthority(e);
				}
			}
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private List<Employee> getRootUser(String path) {
		File file = new File(path);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int index;
			int index2;
			String id;
			String name;
			String password;
			List<Employee> emps = new ArrayList<Employee>();
			while((line = br.readLine()) != null) {
				index = line.indexOf(" ");
				id = line.substring(0, index);
				index2 = line.indexOf(" ", index + 1);
				name = line.substring(index + 1, index2);
				password = line.substring(index2 + 1);
				Employee e = new Employee();
				e.setEmpId(id);
				e.setEmpName(name);
				e.setPassword(password);
				emps.add(e);
			}
			br.close();
			return emps;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
