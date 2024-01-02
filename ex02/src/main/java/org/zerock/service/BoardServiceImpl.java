package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;

	/*
	 * @Override public List<BoardVO> getList() { 
	 * log.info("getList.... >> ");
	 * return boardMapper.getList(); }
	 */
	
	@Override
	public List<BoardVO> getList(Criterial cri) {
		log.info("getListWithPaging.... >> " + cri);
		return boardMapper.getListWithPaging(cri); 
	}


	@Override
	public BoardVO get(Long bno) {
		log.info("getList.... >> ");
		return boardMapper.read(bno);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register ....... > " + board);
		boardMapper.inserteSelectKey(board);
		
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify.... > " + board);
		return boardMapper.update(board)==1;
		
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove.... >> " + bno);
		return boardMapper.delete(bno)==1;
	}


	@Override
	public int getTotal(Criterial cri) {
		log.info("get total count >>");
		return boardMapper.getTotalCount(cri);
	}

	
}
