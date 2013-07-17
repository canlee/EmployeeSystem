package com.icss.employeeSystem.action.Employee;

import java.util.Date;

import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.service.EmployeeService;
import com.icss.framework.base.dao.BaseDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 添加员工信息
 *
 */
public class InsertEmployeeAction extends ActionSupport{

	private EmployeeService employeeService;
	public EmployeeService getEmployeeService() {
		return employeeService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	private String empId;
	private String empName;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String dep;
	private String post;
	private String sex;
	private String salary;
	private String year;
	private String month;
	private String day;
	
	
	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}
	
	
	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDep() {
		return dep;
	}


	public void setDep(String dep) {
		this.dep = dep;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getSalary() {
		return salary;
	}

	
	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String insert(){
		Employee e = (Employee)employeeService.get(Employee.class, getEmpId());
		ActionContext ac = ActionContext.getContext();
		if(e!=null){
			return "fail";
		}
		else{
			try {
				Employee emp = new Employee();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setPassword(password);
				emp.setSex(sex);
				emp.setEmail(email);
				emp.setPhone(phone);
				emp.setAddress(address);
				emp.setSalary(Double.parseDouble(salary));
				emp.setPostId(Integer.parseInt(post));
				Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				emp.setBirthday(date);
				employeeService.save(emp);
				ac.put("empId", empId);
				return "success";
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				return "fail";
			}			
		}
	}
}
