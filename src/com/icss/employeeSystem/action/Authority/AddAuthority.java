package com.icss.employeeSystem.action.Authority;

import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.employeeSystem.service.EOAService;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 为员工添加权限
 *
 */
public class AddAuthority {
	
	private String[] authority;
	private BaseDaoImpl baseDao;
	private EOAService EOAservice;
	private String empId;
	
	
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

	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}

	public String[] getAuthority() {
		return authority;
	}
	
	public void setAuthority(String[] authority) {
		this.authority = authority;
	}
	
	public String add(){
		System.out.println(empId);
		ActionContext ac = ActionContext.getContext();
		try {
			EOAservice.deleteWithEmpId(empId);
			for(int i=0;i<authority.length;++i){
				EOAservice.insert(empId, authority[i]);
			}
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
	}
}
