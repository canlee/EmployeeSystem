package com.icss.employeeSystem.action.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	BaseDaoImpl baseDao;
	
	private String id;
	private String password;
	

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}

	private static final long serialVersionUID = 1L;
	
	public String login() {
		Employee emp = (Employee)baseDao.get(Employee.class, id);
		if(emp!=null&&emp.getPassword().equals(password)){
			try{
				EmployeeVo empvo = new EmployeeVo();
				empvo.setEmpID(emp.getEmpId());
				empvo.setEmpName(emp.getEmpName());
				Post post = (Post)baseDao.get(Post.class, emp.getPostId());
				Department dep = (Department)baseDao.get(Department.class, post.getDepId());				
				empvo.setDepName(dep.getDepName());
				empvo.setDepId(dep.getDepId());
				ActionContext.getContext().getSession().put("employee", empvo);
				
				String sql = "select authId from employee_authority where empId = "+id;
				List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
				list = (List<Map<String,Integer>>)baseDao.queryForList(sql, list);
				List<Integer> authIds = new ArrayList<Integer>();
				for(int i=0;i<list.size();++i){
					authIds.add(list.get(i).get("authId"));
				}
				ActionContext.getContext().getSession().put("authIds", authIds);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "fail";
			}
			return "success";
		}
		else return "fail";
	}
	
}
