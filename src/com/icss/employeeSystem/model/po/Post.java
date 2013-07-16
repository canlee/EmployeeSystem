package com.icss.employeeSystem.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {

	private int postId;
	private int depId;
	private String postName;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "postId" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	@Column(name = "depId" , nullable = false)
	public int getDepId() {
		return depId;
	}
	
	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	@Column(name = "postName" , nullable = false , length = 20)
	public String getPostName() {
		return postName;
	}
	
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	
}
