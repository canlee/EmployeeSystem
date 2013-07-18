package com.icss.employeeSystem.action.Authority;

import java.util.Date;

import com.icss.employeeSystem.model.po.ApplyHoliday;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ApplyHolidayAction extends ActionSupport{

	private String empId;
	private String reason;
	private String holidayLength;
	private String holidayYear;
	private String holidayMonth;
	private String holidayDay;
	private BaseDaoImpl baseDao;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getHolidayLength() {
		return holidayLength;
	}

	public void setHolidayLength(String holidayLength) {
		this.holidayLength = holidayLength;
	}

	public String getHolidayYear() {
		return holidayYear;
	}

	public void setHolidayYear(String holidayYear) {
		this.holidayYear = holidayYear;
	}

	public String getHolidayMonth() {
		return holidayMonth;
	}

	public void setHolidayMonth(String holidayMonth) {
		this.holidayMonth = holidayMonth;
	}

	public String getHolidayDay() {
		return holidayDay;
	}

	public void setHolidayDay(String holidayDay) {
		this.holidayDay = holidayDay;
	}

	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String apply(){
		try {
			Date date = new Date(Integer.parseInt(holidayYear)-1900, Integer.parseInt(holidayMonth), Integer.parseInt(holidayDay));
			Date now = new Date();
			ApplyHoliday applyHoliday = new ApplyHoliday();
			applyHoliday.setEmpId(empId);
			applyHoliday.setDescription(reason);
			applyHoliday.setHolidayDays(Integer.parseInt(holidayLength));
			applyHoliday.setStartTime(date);
			applyHoliday.setApplyTime(now);
			applyHoliday.setStatus("0");		
			baseDao.save(applyHoliday);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}		
	}
}
