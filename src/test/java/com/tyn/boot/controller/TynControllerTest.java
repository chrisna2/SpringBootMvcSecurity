package com.tyn.boot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)//테스트를 실행할 때 테스트 실행 방법을 확장할 때 사용
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)//테스트에 필요한 거의 모든 의존성을 제공한다. ||  MOCK -> 내장 톰켓을 사용하지 않는다.
@AutoConfigureMockMvc//mock 테스트 수행시 필요한 의존성 제공
public class TynControllerTest {

	@Autowired
	MockMvc mockMvc;//객체를 통해 실제 컨테이나기 실행되지 않으나 로직상으로 테스트를 진행 가능
	
	@Test
	public void hello() throws Exception {
		mockMvc.perform(get("/hello"))
			   .andExpect(status().isOk())
			   .andExpect(content().string("hello_spring Boot!!"))
			   .andDo(print());//좀 더 자세한 테스트 결과를 확인 가능
	}
}
