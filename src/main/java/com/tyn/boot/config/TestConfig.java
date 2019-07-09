package com.tyn.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//테스트환경에서 적용되는 설정 클래스
@Profile("test")
@Configuration
public class TestConfig {
	@Bean
	public String hello() {
		return "hello Test Config";
	}
}
