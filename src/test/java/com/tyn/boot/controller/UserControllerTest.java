package com.tyn.boot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tyn.boot.service.TynUserService;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
@WebMvcTest(TynController.class)
public class UserControllerTest {
	
	@Autowired
	MockMvc mockmvc;
	
	@MockBean
	TynUserService movkUserSvc;
	
	@Test
	public void hello() throws Exception{
		
		when(movkUserSvc.getName()).thenReturn("spring Boot!!");
		
		mockmvc.perform(get("/hello")).andExpect(status().isOk())
									  .andExpect(content().string("hello spring Boot!!"))
									  .andDo(print());
	}

}
