package com.icss.employeeSystem.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

	private int depId;
	private String depName;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "depId" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getDepId() {
		return depId;
	}
	
	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	@Column(name = "depName" , nullable = false , length = 20)
	public String getDepName() {
		return depName;
	}
	
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	
}
