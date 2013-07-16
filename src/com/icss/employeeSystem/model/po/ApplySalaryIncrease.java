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
 * 加工资申请
 * @author 李亮灿
 *
 */
@Entity
@Table(name = "applySalaryIncrease")
public class ApplySalaryIncrease extends Apply {

	private int applySalaryId;
	private double applySalary;
	
	/**
	 * 申请加工资的id
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	public int getApplySalaryId() {
		return applySalaryId;
	}
	
	public void setApplySalaryId(int applySalaryId) {
		this.applySalaryId = applySalaryId;
	}
	
	/**
	 * 申请的目标工资
	 * @return
	 */
	@Column(length = 10, precision = 2, nullable = false)
	public double getApplySalary() {
		return applySalary;
	}
	
	public void setApplySalary(double applySalary) {
		this.applySalary = applySalary;
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
