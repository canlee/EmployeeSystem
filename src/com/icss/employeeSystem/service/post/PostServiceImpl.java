package com.icss.employeeSystem.service.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.DepPostsVo;
import com.icss.employeeSystem.repository.post.PostRepository;

@Component("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public DepPostsVo getPostsByDep(int depId) {
		List<Post> posts = postRepository.getPostsByDep(depId);
		DepPostsVo dpv = new DepPostsVo();
		dpv.setDepId(depId);
		List<String> allPost = new ArrayList<String>();
		for(Post p : posts) {
			allPost.add(p.getPostName());
		}
		dpv.setPosts(allPost);
		return dpv;
	}
	
	@Override
	public void insert(Post post) {
		postRepository.insert(post);
	}
	
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

}
