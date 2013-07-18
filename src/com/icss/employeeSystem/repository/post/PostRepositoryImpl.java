package com.icss.employeeSystem.repository.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<Post> getPostsByDep(int depId) {
		String sql = "SELECT * FROM post WHERE depId=" + depId + ";";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = 
				(List<Map<String,Object>>) baseDao.queryForList(
						sql, new ArrayList<Object>());
		List<Post> posts = new ArrayList<Post>();
		for(Map<String, Object> map : result) {
			Post p = new Post();
			p.setPostId((Integer) map.get("postId"));
			p.setDepId((Integer) map.get("depId"));
			p.setPostName((String) map.get("postName"));
			posts.add(p);
		}
		return posts;
	}
	
	@Override
	public void insert(Post post) {
		baseDao.save(post);
	}
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
