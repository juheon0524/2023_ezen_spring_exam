package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
						})
@Log4j
@WebAppConfiguration
public class HomeWorkControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info( mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
	@Test
	public void testRegister() throws Exception{
		
		  String name = mockMvc.perform( MockMvcRequestBuilders.post("/board/register")
				  .param("name", "이름") 
				  .param("age", "1") 
				  .param("birth", "19970524")
				  ) 
				  .andReturn() 
				  .getModelAndView() 
				  .getViewName();
		 
		log.info("view name ==> " + name);
	}
	
	@Test
	public void testGet() throws Exception{
		log.info(
				mockMvc.perform( MockMvcRequestBuilders.get("/board/get")
						  .param("id", "2")) 
						  .andReturn() 
						  .getModelAndView() 
						  .getModelMap()
				);
	}
	
	@Test
	public void testModify() throws Exception{
		
		  String name = mockMvc.perform( MockMvcRequestBuilders.post("/board/modify")
				  .param("id", "3")
				  .param("name", "이름2") 
				  .param("age", "22") 
				  .param("birth", "19970101")
				  ) 
				  .andReturn() 
				  .getModelAndView() 
				  .getViewName();
		 
		log.info("view name ==> " + name);
	}
	
	@Test
	public void testRemove() throws Exception{
		
		  String name = mockMvc.perform( MockMvcRequestBuilders.post("/board/remove")
				  .param("id", "6")
				  ) 
				  .andReturn() 
				  .getModelAndView() 
				  .getViewName();
		 
		log.info("view name ==> " + name);
	}

}
