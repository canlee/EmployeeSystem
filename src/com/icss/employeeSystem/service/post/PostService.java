package com.icss.employeeSystem.service.post;

import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.DepPostsInfoVo;
import com.icss.employeeSystem.model.vo.DepPostsVo;
import com.icss.employeeSystem.model.vo.PostDetailInfoVo;

public interface PostService {

	/**
	 * 根据部门的id获取该部门所有的岗位
	 * @param depId
	 * @return
	 */
	public DepPostsVo getPostsByDep(int depId);
	
	public void insert(Post post);
	
	public DepPostsInfoVo getPostsInfoByDep(int depId);
	
	/**
	 * 根据岗位id获取该岗位的详细信息
	 * @param postId
	 * @return
	 */
	public PostDetailInfoVo getDetailPost(int postId);
	
	public boolean update(Post post);
	
	public void delete(Post post);
	
}
