package com.icss.employeeSystem.action.Authority;

import java.util.Date;

import com.icss.employeeSystem.model.po.ApplySalaryIncrease;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ApplySalaryIncreaseAction extends ActionSupport{

	private String salary;
	private String reason;
	private String empId;
	private BaseDaoImpl baseDao;
	
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
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
			ApplySalaryIncrease asi = new ApplySalaryIncrease();
			asi.setApplySalary(Double.parseDouble(salary));
			asi.setEmpId(empId);
			asi.setDescription(reason);
			Date now = new Date();
			asi.setApplyTime(now);
			asi.setStatus("0");
			baseDao.save(asi);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}

		
	}
	
}
