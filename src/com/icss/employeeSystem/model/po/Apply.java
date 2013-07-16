package com.icss.employeeSystem.model.po;

import java.util.Date;

/**
 * 申请
 * @author 李亮灿
 *
 */
public class Apply {
	
	private String empId;
	private String description;
	private String status;
	private Date applyTime;
	
	public Apply() {
	}

	/**
	 * 申请人的id
	 * @return
	 */
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * 申请描述
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 申请状态，0为正在申请，1为通过申请，2为拒绝申请
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 申请状态，0为正在申请，1为通过申请，2为拒绝申请
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 申请时间
	 * @return
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
}
