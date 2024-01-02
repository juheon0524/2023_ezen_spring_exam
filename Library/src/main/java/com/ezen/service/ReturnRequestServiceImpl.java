package com.ezen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.domain.Criterial;
import com.ezen.domain.ReturnRequestVO;
import com.ezen.mapper.BookMapper;
import com.ezen.mapper.ReturnRequestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReturnRequestServiceImpl implements ReturnRequestService{

	private final ReturnRequestMapper returnRequestMapper;
	
//	private final BookMapper bookMapper;
	
	@Override
	public List<ReturnRequestVO> getList(Criterial cri) {
		return returnRequestMapper.getListWithPaging(cri);
	}

	@Override
	public ReturnRequestVO read(String returnrequestid) {
		return returnRequestMapper.read(returnrequestid);
	}

	@Override
	public void register(ReturnRequestVO returnrequest) {
		returnRequestMapper.insert(returnrequest);
	}

	@Override
	public boolean remove(String returnrequestid) {
		int result = returnRequestMapper.delete(returnrequestid);
		return result > 0;
	}
	
	@Override
	public int getTotal(Criterial cri) {
		log.info("Getting total count with criteria: " + cri);
	    int total = returnRequestMapper.getTotal(cri);
	    log.info("Total count: " + total);
	    return total;
	}

	@Override
	public List<ReturnRequestVO> getListWithPaging(Criterial cri) {
		log.info("Service - returnservice " + cri); // 로그 추가
		return returnRequestMapper.getListWithPaging(cri);
	}

}
