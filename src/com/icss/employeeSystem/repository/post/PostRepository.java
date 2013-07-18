package com.icss.employeeSystem.repository.post;

import java.util.List;

import com.icss.employeeSystem.model.po.Post;

public interface PostRepository {

	public Post getById(int postId);
	
	/**
	 * 根据部门id获取所有的岗位
	 * @param depId
	 * @return
	 */
	public List<Post> getPostsByDep(int depId);
	
	public void insert(Post post);
	
}
