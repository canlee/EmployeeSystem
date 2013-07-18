package com.icss.employeeSystem.service.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.repository.authority.ApplyRepository;

@Component("applyService")
public class ApplyService {

	@Autowired
	private ApplyRepository applyRepository;

	public ApplyRepository getApplyRepository() {
		return applyRepository;
	}

	public void setApplyRepository(
			ApplyRepository applyRepository) {
		this.applyRepository = applyRepository;
	}
	
	public List<?> queryForList(final String sql, final List<?> paras){
		return applyRepository.queryForList(sql, paras);
	}
}
