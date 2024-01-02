package org.zerock.service;

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
public class HomeWorkServiceImpleTests {

	@Autowired
	private HomeWorkService homeWorkService;
	
	@Test
	public void testRegister() {
		HomeWorkVO home = HomeWorkVO.builder()
				.name("새로 작성하는 글2")
				.age(15)
				.birth("20231110")
				.build();
		
		homeWorkService.register(home);
	}
	
	@Test
	public void testGetList() {
		homeWorkService.getList()
			.forEach(home -> log.info(home));
	}
	
	@Test
	public void testGetBno() {
		homeWorkService.get(1L);
	}
	
	@Test
	public void testModify() {
		HomeWorkVO vo = HomeWorkVO.builder()
				.id(1L)
				.name("수정한 타이틀2")
				.age(27)
				.birth("19970524")
				.build();
		boolean result = homeWorkService.modify(vo);
		log.info("result >> " + result);
		
	}
	
	@Test
	public void testRemove() {
		homeWorkService.remove(1L);
	}
	
}
