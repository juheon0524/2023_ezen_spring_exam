package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImpleTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
				.title("새로 작성하는 글")
				.content("새로 작성하는 내용")
				.writer("newbie")
				.build();
		
		boardService.register(board);
	}
	
	@Test
	public void testGetList(Criterial cri) {
		boardService.getList(cri)
			.forEach(board -> log.info(board));
	}
	
	@Test
	public void testGetBno() {
		boardService.get(1L);
	}
	
	@Test
	public void testModify() {
		BoardVO vo = BoardVO.builder()
				.bno(1L)
				.title("수정한 타이틀")
				.content("수정한 내용")
				.writer("수정자")
				.build();
		boolean result = boardService.modify(vo);
		log.info("result >> " + result);
		
	}
	
	@Test
	public void testRemove() {
		boardService.remove(1L);
	}
}
