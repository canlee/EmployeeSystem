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

import com.icss.employeeSystem.model.po.Authority;
import com.icss.employeeSystem.repository.init.AuthorityRepository;

public class InitAuthorityServiceImpl implements InitAuthorityService {

	private Connection connection;
	
	public InitAuthorityServiceImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void initAuthority(String configPath) {
		AuthorityRepository resp = new AuthorityRepository(connection);
		try {
			List<Authority> currentAus = getCurrentAuthorities(configPath);
			List<Authority> dbAus = resp.getAllAuthorities();
			connection.setAutoCommit(false);
			if(currentAus != null && dbAus != null) {
				for(Authority dbAu: dbAus) {
					if(!currentAus.contains(dbAu)) {
						resp.delete(dbAu);
					}
				}
				for(Authority curAu : currentAus) {
					if(!dbAus.contains(curAu)) {
						resp.insert(curAu);
					}
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
	
	/**
	 * 读取配置文件中的所有权限
	 * @param path
	 * @return
	 */
	private List<Authority> getCurrentAuthorities(String path) {
		File file = new File(path);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			String id;
			String name;
			int index;
			List<Authority> result = new ArrayList<Authority>();
			while ((line = br.readLine()) != null) {
				index = line.indexOf(" ");
				id = line.substring(0, index);
				name = line.substring(index + 1);
				Authority au = new Authority();
				au.setAuthorityId(Integer.parseInt(id));
				au.setAuthorityName(name);
				result.add(au);
			}
			br.close();
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
