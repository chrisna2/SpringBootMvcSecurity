package com.tyn.boot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class PropertyRunner implements ApplicationRunner {
	
	Logger log = LoggerFactory.getLogger(PropertyRunner.class);
	
	//@Value : properties 파일 에서 설정한 정의 값읋 바로 가져다 사용이 가능하다.
	@Value("${user.name}")
	private String name;
	
	@Value("${user.fullname}")
	private String fullname;
	
	@Value("${user.age}")
	private int age;
	/**
	 * in springframework>
	 * XML에 설정을 해야 했던 부분들이 이렇게 어노테이션 한방으로 설정이 가능하다.
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("=============|PropertyRunner:2|=============");
		log.debug("이름 : "+name);
		log.debug("성함 : "+fullname);
		log.debug("나이 : "+age);
		log.info("This is Info Log -> hello prod env");
		log.debug("This is Debug Log-> hello test env");
		/* 까먹은 것들 : 로그레벨
		 * debug레벨에서는 info까지 다보인다.
		 * info 레벨에선 info만 보인다.
		 */
	}

	
	
}
