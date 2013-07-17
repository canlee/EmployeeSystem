package com.icss.employeeSystem.action.Employee;

import java.util.Date;

import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.employeeSystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateEmployeeAction extends ActionSupport{

	private String empId;
	private String empName;
	private String dep;
	private String post;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String sex;
	private String year;
	private String month;
	private String day;
	private String salary;
	private EmployeeService employeeService;
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

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
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String update(){
		try {
			ActionContext ac = ActionContext.getContext();
			if(empId==null){
				setEmpId(((EmployeeVo)ac.getSession().get("employee")).getEmpID());				
			}
			Employee emp = (Employee)employeeService.get(Employee.class, empId);
			if(salary!=null){
				emp.setSalary(Double.parseDouble(salary));
			}
			if(post!=null){
				emp.setPostId(Integer.parseInt(post));
			}
			emp.setEmpName(empName);
			emp.setSex(sex);
			emp.setEmail(email);
			emp.setPhone(phone);
			emp.setAddress(address);
			//Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			//emp.setBirthday(date);
			employeeService.update(emp);
			return "success";			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}

	}
	
	public String updatePwd(){
		ActionContext ac = ActionContext.getContext();
		setEmpId(((EmployeeVo)ac.getSession().get("employee")).getEmpID());			
		Employee emp = (Employee)employeeService.get(Employee.class, empId);
		emp.setPassword(password);
		employeeService.update(emp);
		return "success";
	}
}
