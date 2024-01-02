package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.HomeWorkVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HomeWorkMapperTests {
	
	@Autowired
	private HomeWorkMapper mapper;
	
	@Test
	public void testGetList() {
		List<HomeWorkVO> list = mapper.getList();
		for(HomeWorkVO vo : list)
			log.info(vo);
	}
	
	@Test
	public void testInserteSelectKey() {
		HomeWorkVO vo = HomeWorkVO.builder()
				.name("인서트5")
				.age(21)
				.birth("19970524")
				.build();
		
		mapper.inserteSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		HomeWorkVO vo = mapper.read(1L);
		log.info("vo >> " + vo);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(7L);
	}
	
	@Test
	public void testUpdate() {
		HomeWorkVO vo = HomeWorkVO.builder()
				.id(5L)
				.name("수정 제목2")
				.age(14)
				.birth("19970524")
				.build();
		
		int result = mapper.update(vo);
		log.info("result >> " + result);
	}
}
