package com.tyn.boot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.service.TynUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//RANDOM_PORT : 내장 톰켓을 사용  -> TestRestTemplate나 WebTestClient를 사용해야 한다.
public class TynControllerRestTemplateTest {

	//[1] mockup 테스트가 아니기 때문에 mockMvc 객체가 아닌 TestRestTemplate 객체같은 다른 방식으로 테스트를 해야됩
	@Autowired
	TestRestTemplate testRestTemplate;
	
	//[2] 컨트롤러만 테스트를 수행하려면 서비스를 mockup으로 만들고 테스트 할 수 있다.
	@MockBean
	TynUserService mockService;
	
	@Test
	public void hello() throws Exception {
		
		//[2] 실제 서비스의 출력은 "Spring boot!!" 출력 서비스의 내용을 가정하고 테스트 할 수도 있었다. ㅠㅠ
		when(mockService.getName()).thenReturn("hyunkeeNa");
		
		
		//[1] 컨트롤러 만 테스트
		String result = testRestTemplate.getForObject("/hello", String.class);
		assertThat(result).isEqualTo("hello_hyunkeeNa");
	}
	
}
