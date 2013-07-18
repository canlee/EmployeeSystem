package com.icss.employeeSystem.repository.post;

import java.util.List;

import com.icss.employeeSystem.model.po.Employee;
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
	
	/**
	 * 根据岗位的id获取该岗位的所有人员
	 * @param postId
	 * @return
	 */
	public List<Employee> getAllEmployees(int postId);
	
}
