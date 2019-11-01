package com.tyn.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:/test.properties")
@SpringBootTest
public class TynPa01StartApplicationTests {
	
	@Autowired
	Environment enviroment;
	
	@Test
	public void contextLoads() {
		//test.properties 에 hyunkee.name=chrisna2 였음...그게 같은지 확인
		assertThat(enviroment.getProperty("hyunkee.name")).isEqualTo("chrisna2");
	}

}
