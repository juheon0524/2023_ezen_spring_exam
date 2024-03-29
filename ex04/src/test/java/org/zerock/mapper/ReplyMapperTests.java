package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {
			188422L,188423L,188424L,188425L,188426L
	};
	
	@Test
	public void testGetCountByBno() {
		mapper.getCountByBno(188422L);
	}
	
	
	@Test
	public void testGetListWithPaging() {
		
	/*	List<ReplyVO> list = 
			mapper.getListWithPaging(new Criterial(), 1015842L);
		
		for(ReplyVO vo : list)
			log.info(vo); */
		
		
		
		mapper.getListWithPaging(new Criterial(2,2), 188422L)
			.forEach(reply->log.info(reply));
	}
	
	@Test
	public void testUpdate() {
	
		ReplyVO vo = ReplyVO.builder()
				.reply("댓글수정2")
				.rno(1L)
				.build();
		mapper.update(vo);
	}
	
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(12L));
	}
	
	
	@Test
	public void testRead() {
		log.info(mapper.read(1L));
	}
	
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1,  10).forEach(i -> {
			ReplyVO vo = ReplyVO.builder()
					.bno(bnoArr[i % 5])
					.reply("오늘댓글 테스트 " + i)
					.replyer("오늘댓글자 " + i)
					.build();
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testCreate2() {
		
			ReplyVO vo = ReplyVO.builder()
					.bno(1015842L)
					.reply("댓글 테스트4 ")
					.replyer("댓글러 4")
					.build();
			mapper.insert(vo);
		
	}
	
	
	@Test
	public void testMapper() {
		log.info(">>>>>>>>>>" + mapper);
	}
	
	
	
	
	
	
	
	
	
	
	
}
