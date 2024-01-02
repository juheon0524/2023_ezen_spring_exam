package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceImpleTest {

	@Autowired
	private SampleTxServiceImple serviceImple;
	
	
	@Test
	public void test() {
		String str = "정부 여당과 동물보호 단체들이";
		log.info("length >> " + str.getBytes().length);
		serviceImple.addData(str);
	
	}

}
