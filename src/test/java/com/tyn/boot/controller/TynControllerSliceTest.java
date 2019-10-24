package com.tyn.boot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tyn.boot.service.TynUserService;

@RunWith(SpringRunner.class)
@WebMvcTest(TynController.class)//웹테스트를 하는데 필요한 어노테이션만 등록이 된다. 
public class TynControllerSliceTest {

	/*
	 * layer 별로 나누어 테스트 가능
	 * @WebMvcTest -> 일반적으로 사용하는 웹 MVC 테스트용 어노테이션
	 * @WebFluxTest -> 리액티브로 만든 Controller는 Spring MVC의 @WebMvcTest와 기능이 유사한 @WebFluxTest를 사용해서 테스트 할 수 있다. 
	 *                 특히 WebTestClient 는 자동으로 설정된다.
	 * @DataJpaTest -> JPA 전용 DB 데이터 확인 테스트 어노테이션
	 * 
	 * @WebMvcTest 어노테이션 등록시
	 * 웹테스트를 하는데 필요한 
	 * @Controller
	 * @ControllerAdvice
	 * @JsonComponent등의 어노테이션만 등록이 된다.
	 * 
	 * 웹테스트를 하는 데 필요하지 않은 어노테이션은 등록되지 않는다. 
	 */
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TynUserService mockService;
	
	@Test
	public void hello() throws Exception{
		when(mockService.getName()).thenReturn("chrisna2");
		
		mockMvc.perform(get("/hello"))
			   .andExpect(status().isOk())
			   .andExpect(content().string("hello_chrisna2"))
			   .andDo(print());
	}
}
