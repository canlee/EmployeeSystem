package com.icss.employeeSystem.service.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.DepPostsInfoVo;
import com.icss.employeeSystem.model.vo.DepPostsVo;
import com.icss.employeeSystem.model.vo.EmpPostInfoVo;
import com.icss.employeeSystem.model.vo.PostDetailInfoVo;
import com.icss.employeeSystem.model.vo.PostVo;
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
	public DepPostsInfoVo getPostsInfoByDep(int depId) {
		List<Post> posts = postRepository.getPostsByDep(depId);
		DepPostsInfoVo dpiv = new DepPostsInfoVo();
		dpiv.setDepId(depId);
		List<PostVo> allPosts = new ArrayList<PostVo>();
		for(Post p : posts) {
			PostVo pv = new PostVo();
			pv.setPostId(p.getPostId());
			pv.setPostName(p.getPostName());
			allPosts.add(pv);
		}
		dpiv.setPosts(allPosts);
		return dpiv;
	}
	
	@Override
	public PostDetailInfoVo getDetailPost(int postId) {
		PostDetailInfoVo pdiv = new PostDetailInfoVo();
		Post p = postRepository.getById(postId);
		pdiv.setPostName(p.getPostName());
		List<Employee> emps = postRepository.getAllEmployees(postId);
		pdiv.setEmployeeCount(emps.size());
		List<EmpPostInfoVo> epivs = new ArrayList<EmpPostInfoVo>();
		for(Employee e : emps) {
			EmpPostInfoVo epiv = new EmpPostInfoVo();
			epiv.setEmpId(e.getEmpId());
			epiv.setEmpName(e.getEmpName());
			epivs.add(epiv);
		}
		pdiv.setEmployees(epivs);
		return pdiv;
	}
	
	@Override
	public void insert(Post post) {
		postRepository.insert(post);
	}
	
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

}
