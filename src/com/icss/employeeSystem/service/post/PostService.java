package com.icss.employeeSystem.service.post;

import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.DepPostsVo;

public interface PostService {

	/**
	 * 根据部门的id获取该部门所有的岗位
	 * @param depId
	 * @return
	 */
	public DepPostsVo getPostsByDep(int depId);
	
	public void insert(Post post);
	
}
