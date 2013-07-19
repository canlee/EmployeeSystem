package com.icss.employeeSystem.action.Authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.employeeSystem.service.authority.ApplyService;
import com.icss.employeeSystem.util.ApplyComparator;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryApplyAction extends ActionSupport{
	
	private String empId = "%";
	private String status = "%";
	private String type = "-1";
	private String department = "%";
	private String target;
	private String applyId = "%";
	private ApplyService applyService;
	private BaseDaoImpl baseDao;
	
	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
		if(target.equals("show"))empId = ((EmployeeVo)ac.getSession().get("employee")).getEmpID();
		if(empId.equals(""))empId = "%";
		if(target.equals("verify"))status = "0";
		List<Map<String, Object>> HolidayList = null;
		List<Map<String, Object>> SalaryList = null;
		List<Map<String, Object>> DepList = null;
		List<Map<String, Object>> ApplyList = new ArrayList<Map<String,Object>>();
				
		int flag = Integer.parseInt(type);
		try {
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
			for(int i=0;i<DepList.size();++i){
				DepList.get(i).put("type", "2");
				try {
					Post post = (Post)baseDao.get(Post.class, (Integer)DepList.get(i).get("applyPost"));
					Department dep =(Department)baseDao.get(Department.class, post.getDepId());
					DepList.get(i).put("applyPostName", post.getPostName());
					DepList.get(i).put("applyDepName", dep.getDepName());					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();					
					return "fail";
				}

			}
			ApplyList.addAll(DepList);
		}
		
		Collections.sort(ApplyList, new ApplyComparator());
		ac.put("ApplyList", ApplyList);
		return target;
		
	}
	
	public List<Map<String, Object>> queryHolidayApply(){
		ActionContext ac = ActionContext.getContext();
		List<Integer> authIds = (List<Integer>)ac.getSession().get("authIds");
		if(!authIds.contains(19)){
			department = ((EmployeeVo)ac.getSession().get("employee")).getDepName();
		}
		if((!authIds.contains(19)&&!authIds.contains(20))&&(target.equals("showall")||target.equals("vetify"))){
			return null;
		}
		String sql = "select * from applyholiday,employee,post,department where employee.empId = applyholiday.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? and applyholiday.status like ? and " +
				"applyHoliday.applyHolidayId like ?";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(department);
		param.add(status);
		param.add(applyId);
		try {
			return (List<Map<String, Object>>)applyService.queryForList(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Map<String, Object>> queryChangeDepApply(){
		ActionContext ac = ActionContext.getContext();
		List<Integer> authIds = (List<Integer>)ac.getSession().get("authIds");
		if(!authIds.contains(22)&&(target.equals("showall")||target.equals("vetify"))){
			return null;
		}
		String sql = "select * from applychangedep,employee,post,department where employee.empId = applychangedep.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? and applychangedep.status like ? and " +
				"applychangedep.applyDepId like ?";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(department);
		param.add(status);
		param.add(applyId);
		try {
			return (List<Map<String, Object>>)applyService.queryForList(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Map<String, Object>> querySalaryIncreaseApply(){
		ActionContext ac = ActionContext.getContext();
		List<Integer> authIds = (List<Integer>)ac.getSession().get("authIds");
		if(!authIds.contains(21)&&(target.equals("showall")||target.equals("vetify"))){
			return null;
		}
		String sql = "select * from applysalaryincrease,employee,post,department where employee.empId = applysalaryincrease.empId and employee.postId = post.postId " +
				"and post.depId = department.depId and employee.empId like ? and department.depName like ? and applysalaryincrease.status like ? and " +
				"applysalaryincrease.applySalaryId like ?";
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(department);
		param.add(status);
		param.add(applyId);
		try {
			return (List<Map<String, Object>>)applyService.queryForList(sql, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
