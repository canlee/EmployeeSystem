package com.icss.employeeSystem.model.vo;

import java.util.List;

/**
 * 在查询岗位页面时选择部门后显示有多少个岗位的时候显示的
 * @author 李亮灿
 *
 */
public class DepPostsInfoVo {

	private int depId;
	private List<PostVo> posts;
	
	public int getDepId() {
		return depId;
	}
	
	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	public List<PostVo> getPosts() {
		return posts;
	}
	
	public void setPosts(List<PostVo> posts) {
		this.posts = posts;
	}
	
}
