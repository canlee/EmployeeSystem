package com.icss.employeeSystem.service.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.model.vo.DepartmentInfoVo;
import com.icss.employeeSystem.model.vo.EmpDepInfoVo;
import com.icss.employeeSystem.repository.department.DepartmentRepository;
import com.icss.employeeSystem.repository.post.PostRepository;

@Component("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.getAllDepartment();
	}
	
	@Override
	public boolean inset(Department dep) {
		if(departmentRepository.getDepartmentByName(dep.getDepName()) == null) {
			int id = departmentRepository.insert(dep);
			dep.setDepId(id);
			return true;
		}
		return false;
	}
	
	@Override
	public DepartmentInfoVo getDepartmentInfo(int depId) {
		DepartmentInfoVo depInfo = new DepartmentInfoVo();
		depInfo.setDepId(depId);
		depInfo.setDepName(departmentRepository.getById(depId).getDepName());
		List<Employee> emps = 
				departmentRepository.getEmployeeInDepartment(depId);
		depInfo.setEmployeeCount(emps.size());
		List<EmpDepInfoVo> empInfo = new ArrayList<EmpDepInfoVo>();
		for(Employee e : emps) {
			EmpDepInfoVo edi = new EmpDepInfoVo();
			edi.setEmpId(e.getEmpId());
			edi.setEmpName(e.getEmpName());
			edi.setPostId(e.getPostId());
			edi.setPostName(postRepository.getById(e.getPostId()).getPostName());
			empInfo.add(edi);
		}
		depInfo.setEmployees(empInfo);
		return depInfo;
	}
	
	@Override
	public boolean update(Department dep) {
		return departmentRepository.update(dep);
	}
	
	public void setDepartmentRepository(
			DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

}
