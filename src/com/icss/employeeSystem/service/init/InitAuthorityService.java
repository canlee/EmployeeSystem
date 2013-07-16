package com.icss.employeeSystem.service.init;

public interface InitAuthorityService {

	/**
	 * 根据配置文件读取出所有的权限，与数据库中所有的权限对比，没有的增加，多余的就删除
	 * @param configPath
	 */
	public void	initAuthority(String configPath);
	
}
