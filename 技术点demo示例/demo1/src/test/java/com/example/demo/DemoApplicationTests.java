package com.example.demo;

import com.example.demo.entity.DemoUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);


	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//初始化MockMvc
	}

	@Test
	public void contextLoads() {
		DemoUser demoUser = new DemoUser();
		demoUser.setAge("35");
		demoUser.setBirthday(new Date());
		demoUser.setUsername("TT");
		logger.info("demoUser---------->"+demoUser.toString());

	}
	@Test
	public void testGetAllUsers() throws Exception{
		String response = mockMvc.perform(get("/demo/getMessage").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		log.info("-------------返回的json---》"+response);
	}
}
