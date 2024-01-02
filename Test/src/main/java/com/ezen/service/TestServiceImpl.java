package com.ezen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.domain.TestVO;
import com.ezen.mapper.TestMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

	private final TestMapper mapper;
	
	@Override
	public List<TestVO> getList() {
		return mapper.getList();
		
	}

}
