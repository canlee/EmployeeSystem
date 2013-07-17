package com.icss.employeeSystem.action.Authority;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import com.icss.employeeSystem.service.EOAService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAuthorityAction extends ActionSupport{

	private String empId;
	private EOAService EOAservice;
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public EOAService getEOAservice() {
		return EOAservice;
	}
	
	public void setEOAservice(EOAService eOAservice) {
		EOAservice = eOAservice;
	}
	
	public String query(){
		ActionContext ac = ActionContext.getContext();
		String sql = "select authorityId from employee_authority,Authority where employee_authority.authId = Authority.authorityId and employee_authority.empId = "+empId;
		try {
			List<Map<String, String>> authorityList = new ArrayList<Map<String,String>>();
			authorityList = (List<Map<String, String>>)EOAservice.queryForList(sql, authorityList);
			ac.put("authorityList", authorityList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
}
