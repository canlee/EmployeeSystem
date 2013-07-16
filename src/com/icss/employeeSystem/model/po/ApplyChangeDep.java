package com.icss.employeeSystem.model.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 调部门申请
 * @author 李亮灿
 *
 */
@Entity
@Table(name = "applyChangeDep")
public class ApplyChangeDep extends Apply {

	private int applyDepId;
	private String applyDepartment;
	private String applyPost;
	
	/**
	 * 申请调部门的id
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	public int getApplyDepId() {
		return applyDepId;
	}
	
	public void setApplyDepId(int applyDepId) {
		this.applyDepId = applyDepId;
	}
	
	/**
	 * 申请要调的部门
	 * @return
	 */
	@Column(length = 20, nullable = false)
	public String getApplyDepartment() {
		return applyDepartment;
	}
	
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	
	/**
	 * 申请要调的岗位
	 * @return
	 */
	@Column(length = 20, nullable = false)
	public String getApplyPost() {
		return applyPost;
	}
	
	public void setApplyPost(String applyPost) {
		this.applyPost = applyPost;
	}
	
	@Override
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getApplyTime() {
		return super.getApplyTime();
	}
	
	@Override
	@Column(length = 300)
	public String getDescription() {
		return super.getDescription();
	}
	
	@Override
	@Column(length = 16, nullable = false)
	public String getEmpId() {
		return super.getEmpId();
	}
	
	@Override
	@Column(length = 1, nullable = false)
	public String getStatus() {
		return super.getStatus();
	}
	
}