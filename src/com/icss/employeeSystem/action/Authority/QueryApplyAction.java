package com.icss.employeeSystem.action.Authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.icss.employeeSystem.service.authority.ApplyService;
import com.icss.employeeSystem.util.ApplyComparator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryApplyAction extends ActionSupport{
	
	private String empId = "%";
	private String status = "%";
	private String type = "-1";
	private String deppartment = "%";
	private String target;
	private ApplyService applyService;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeppartment() {
		return deppartment;
	}

	public void setDeppartment(String deppartment) {
		this.deppartment = deppartment;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}
	
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
		ActionContext ac = ActionContext.getContext();
		if(empId.equals(""))empId = "%";
		List<Map<String, Object>> HolidayList = null;
		List<Map<String, Object>> SalaryList = null;
		List<Map<String, Object>> DepList = null;
		List<Map<String, Object>> ApplyList = new ArrayList<Map<String,Object>>();
				
		int flag = Integer.parseInt(type);
		try {
			switch(flag){
				case 0:{
					HolidayList = queryHolidayApply();
					System.out.println(flag);
					break;
				}
				case 1:{
					SalaryList = querySalaryIncreaseApply();
					System.out.println(flag);
					break;
				}
				case 2:{
					DepList = queryChangeDepApply();
					System.out.println(flag);
					break;
				}
				default:{
					HolidayList = queryHolidayApply();
					SalaryList = querySalaryIncreaseApply();
					DepList = queryChangeDepApply();
					System.out.println(flag);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}

		
		if(HolidayList!=null){
			for(int i=0;i<HolidayList.size();++i)HolidayList.get(i).put("type", "0");
			ApplyList.addAll(HolidayList);
		}
		if(SalaryList!=null){
			for(int i=0;i<SalaryList.size();++i)SalaryList.get(i).put("type", "1");
			ApplyList.addAll(SalaryList);
		}
		if(DepList!=null){
			for(int i=0;i<DepList.size();++i)DepList.get(i).put("type", "2");
			ApplyList.addAll(DepList);
		}
		
		Collections.sort(ApplyList, new ApplyComparator());
		ac.put("ApplyList", ApplyList);
		return target;
		
	}
	
	public List<Map<String, Object>> queryHolidayApply(){
		String sql = "select * from applyholiday,employee,post,department where employee.empId = applyholiday.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? and applyholiday.status like ? ";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(deppartment);
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
		String sql = "select * from applychangedep,employee,post,department where employee.empId = applychangedep.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? and applychangedep.status like ? ";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(deppartment);
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
		String sql = "select * from applysalaryincrease,employee,post,department where employee.empId = applysalaryincrease.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? and applysalaryincrease.status like ? ";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(deppartment);
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
