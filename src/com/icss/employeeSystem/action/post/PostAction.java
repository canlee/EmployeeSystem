package com.icss.employeeSystem.action.post;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.icss.employeeSystem.action.BaseAction;
import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.po.Post;
import com.icss.employeeSystem.model.vo.DepPostsVo;
import com.icss.employeeSystem.service.department.DepartmentService;
import com.icss.employeeSystem.service.post.PostService;
import com.icss.employeeSystem.util.JsonUtil;

public class PostAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private DepartmentService departmentService;
	
	private PostService postService;
	
	public String getInsertPostPage() {
		List<Department> deps = departmentService.getAllDepartment();
		getRequest().setAttribute("departments", deps);
		return "success";
	}
	
	public void getPostsByDep() {
		int depId;
		try {
			depId = Integer.parseInt(getRequest().getParameter("depId"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		DepPostsVo dpv = postService.getPostsByDep(depId);
		PrintWriter out;
		try {
			out = getWriter();
			JsonUtil.sendJson(out, "posts", dpv);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String insert() {
		HttpServletRequest req = getRequest();
		try {
			int depId = Integer.parseInt(req.getParameter("depId"));
			String postName = req.getParameter("postName");
			Post post = new Post();
			post.setDepId(depId);
			post.setPostName(postName);
			postService.insert(post);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

}
