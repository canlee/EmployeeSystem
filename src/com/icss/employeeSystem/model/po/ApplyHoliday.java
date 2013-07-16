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
 * 请假申请
 * @author 李亮灿
 *
 */
@Entity
@Table(name = "applyHoliday")
public class ApplyHoliday extends Apply {

	private int applyHolidayId;
	private Date startTime;
	private int holidayDays;
	
	/**
	 * 申请请假的id
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	public int getApplyHolidayId() {
		return applyHolidayId;
	}
	
	public void setApplyHolidayId(int applyHolidayId) {
		this.applyHolidayId = applyHolidayId;
	}
	
	/**
	 * 请假开始时间
	 * @return
	 */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 请多少天的假
	 * @return
	 */
	@Column(nullable = false)
	public int getHolidayDays() {
		return holidayDays;
	}
	
	public void setHolidayDays(int holidayDays) {
		this.holidayDays = holidayDays;
	}
	
	@Override
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getApplyTime() {
		return super.getApplyTime();
	}
	
	@Override
	@Column(length = 16, nullable = false)
	public String getEmpId() {
		return super.getEmpId();
	}
	
	@Override
	@Column(length = 300)
	public String getDescription() {
		return super.getDescription();
	}
	
	@Override
	@Column(length = 1, nullable = false)
	public String getStatus() {
		return super.getStatus();
	}
	
}
