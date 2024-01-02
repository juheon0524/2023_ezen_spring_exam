package org.zerock.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for(BoardVO vo : list)
			log.info(vo);
		
//		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = BoardVO.builder()
				.title("인서트3")
				.content("인서트 내용")
				.writer("조운")
				.build();
		
		mapper.insert(vo);
	}
	
	@Test
	public void testInserteSelectKey() {
		BoardVO vo = BoardVO.builder()
				.title("인서트5")
				.content("인서트 내용")
				.writer("조운5")
				.build();
		
		mapper.inserteSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1L);
		log.info("vo >> " + vo);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(9L);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = BoardVO.builder()
				.bno(7L)
				.title("수정 제목")
				.content("수정 내용")
				.writer("수정자")
				.build();
		
		int result = mapper.update(vo);
		log.info("result >> " + result);
	}
	
	@Test
	public void testGetListWithPaggin() {
		Criterial cri = new Criterial();
		cri.setPageNum(3);
		cri.setAmount(20);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testCount() {
		log.info(mapper.getTotalCount(new Criterial(1,10)));
	}
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("T", "hean");
		map.put("C", "수정");
		map.put("W", "조조");
		
		Map<String, Map<String, String>> outer = new HashMap<String, Map<String,String>>();
		outer.put("map", map);
		List<BoardVO> list = mapper.searchTest(outer);
		log.info(list);
	}
	
	@Test
	public void testSearchPaging() {
		Criterial cri = new Criterial();
		cri.setType("TCW");
		cri.setKeyword("조조");
		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		log.info(list);
		mapper.getListWithPaging(cri).forEach(list -> log.info(list));
	}
}
