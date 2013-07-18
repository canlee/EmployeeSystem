package com.icss.employeeSystem.action.Authority;

import java.util.Date;

import com.icss.employeeSystem.model.po.ApplyChangeDep;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ApplyChangeDepAction extends ActionSupport{

	private String empId;
	private String post;
	private String reason;
	private BaseDaoImpl baseDao;
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}
	
	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}
	
	public String apply(){		
		try {
			ApplyChangeDep acd = new ApplyChangeDep();
			acd.setEmpId(empId);
			acd.setDescription(reason);
			acd.setApplyPost(Integer.parseInt(post));
			acd.setStatus("0");
			Date now = new Date();
			acd.setApplyTime(now);
			baseDao.save(acd);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
	}
}
