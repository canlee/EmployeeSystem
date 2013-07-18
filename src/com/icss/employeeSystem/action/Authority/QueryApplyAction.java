package com.icss.employeeSystem.action.Authority;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.employeeSystem.service.authority.ApplyService;
import com.opensymphony.xwork2.ActionSupport;

public class QueryApplyAction extends ActionSupport{
	
	private String empId;
	private String status;
	private String type;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	private String dep;
	private ApplyService applyService;
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public ApplyService getApplyService() {
		return applyService;
	}
	
	public void setApplyHolidayService(ApplyService applyService) {
		this.applyService = applyService;
	}
	
	public String query(){
		String sql;
		List<String> param = new ArrayList<String>();
		List<Map<String, Object>> HolidayList;
		List<Map<String, Object>> SalaryList;
		List<Map<String, Object>> DepList;
		
		int flag = Integer.parseInt(type);
		switch(flag){
			case 0:{
				HolidayList = queryHolidayApply();
				break;
			}
			case 1:{
				SalaryList = querySalaryIncreaseApply();
				break;
			}
			case 2:{
				DepList = queryChangeDepApply();
				break;
			}
			default:{
				HolidayList = queryHolidayApply();
				SalaryList = querySalaryIncreaseApply();
				DepList = queryChangeDepApply();
				break;
			}
		}
		
		sql = "select * from applyholiday,employee where employee.empId = applyholiday.empId and empId like ?";
		
	}
	
	public List<Map<String, Object>> queryHolidayApply(){
		String sql = "select * from applyholiday,employee,post,department where employee.empId = applyholiday.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? applyholiday.status like ? ";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(dep);
		param.add(status);
		try {
			return (List<Map<String, Object>>)applyService.queryForList(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Map<String, Object>> queryChangeDepApply(){
		String sql = "select * from applychangedep,employee,post,department where employee.empId = applyholiday.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? applyholiday.status like ? ";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(dep);
		param.add(status);
		try {
			return (List<Map<String, Object>>)applyService.queryForList(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Map<String, Object>> querySalaryIncreaseApply(){
		String sql = "select * from applysalaryincrease,employee,post,department where employee.empId = applyholiday.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? applyholiday.status like ? ";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(dep);
		param.add(status);
		try {
			return (List<Map<String, Object>>)applyService.queryForList(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
