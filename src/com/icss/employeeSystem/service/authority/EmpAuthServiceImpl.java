package com.icss.employeeSystem.service.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.repository.authority.EmpAuthRepository;

@Component("empAuthService")
public class EmpAuthServiceImpl implements EmpAuthService {

	@Autowired
	private EmpAuthRepository empAuthRepository;
	
	@Override
	public List<Integer> getAllAuthorities(String empId) {
		return empAuthRepository.getAllAuthorities(empId);
	}
	
	public void setEmpAuthRepository(EmpAuthRepository empAuthRepository) {
		this.empAuthRepository = empAuthRepository;
	}

}
