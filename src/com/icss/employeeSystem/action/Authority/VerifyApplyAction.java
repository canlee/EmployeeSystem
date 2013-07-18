package com.icss.employeeSystem.action.Authority;

import org.quartz.impl.calendar.HolidayCalendar;

import com.icss.employeeSystem.model.po.ApplyChangeDep;
import com.icss.employeeSystem.model.po.ApplyHoliday;
import com.icss.employeeSystem.model.po.ApplySalaryIncrease;
import com.icss.employeeSystem.model.po.Employee;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class VerifyApplyAction extends ActionSupport{

	private String applyId;
	private String type;
	private String empId;
	private String status;
	private String salary;
	private String post;
	
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	private BaseDaoImpl baseDao;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplyId() {
		return applyId;
	}
	
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}
	
	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}
	
	public String verify(){
		int flag = Integer.parseInt(type);
		Employee emp = null;
		System.out.println(applyId);
		try {
			switch(flag){
				case 0:{
					ApplyHoliday ah = (ApplyHoliday)baseDao.get(ApplyHoliday.class, Integer.parseInt(applyId));
					ah.setStatus(status);
					baseDao.update(ah);
					break;
				}
				case 1:{
					ApplySalaryIncrease asi = (ApplySalaryIncrease)baseDao.get(ApplySalaryIncrease.class, Integer.parseInt(applyId));
					asi.setStatus(status);
					baseDao.update(asi);
					if(status.equals("1")){
						emp = (Employee)baseDao.get(Employee.class, empId);
						emp.setSalary(Double.parseDouble(salary));
						baseDao.update(emp);
					}
					break;
				}
				case 2:{
					ApplyChangeDep acd = (ApplyChangeDep)baseDao.get(ApplyChangeDep.class, Integer.parseInt(applyId));
					acd.setStatus(status);
					baseDao.update(acd);
					if(status.equals("1")){
						emp = (Employee)baseDao.get(Employee.class, empId);
						emp.setPostId(Integer.parseInt(post));
						baseDao.update(emp);
					}
					break;
				}
				default:{
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
}














