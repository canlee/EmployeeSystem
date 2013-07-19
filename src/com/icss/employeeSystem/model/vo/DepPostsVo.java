package com.icss.employeeSystem.model.vo;

import java.util.List;

/**
 * 一个部门下的所有岗位
 * @author 李亮灿
 *
 */
public class DepPostsVo {

	private int depId;
	private List<String> posts;
	
	public int getDepId() {
		return depId;
	}
	
	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	/**
	 * 该部门下的所有id
	 * @return
	 */
	public List<String> getPosts() {
		return posts;
	}
	
	public void setPosts(List<String> posts) {
		this.posts = posts;
	} 
	
	
}
