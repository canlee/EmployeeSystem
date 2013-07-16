package com.icss.employeeSystem.model.vo;

import java.util.List;

import com.icss.employeeSystem.model.po.Authority;

public class AuthorityOfEmployee {

	List<Authority> authorityList;

	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}	
}
