package com.icss.employeeSystem.repository.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Post;
import com.icss.framework.base.dao.BaseDao;

@Component("postRepository")
public class PostRepositoryImpl implements PostRepository {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Post getById(int postId) {
		return (Post) baseDao.get(Post.class, postId);
	}
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
