package com.icss.employeeSystem.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authority")
public class Authority {

	private int authorityId;
	private String authorityName;
	
	public Authority() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "authorityId" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAuthorityId() {
		return authorityId;
	}
	
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	
	@Column(name = "authorityName" , nullable = false , length = 20)
	public String getAuthorityName() {
		return authorityName;
	}
	
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	
}
