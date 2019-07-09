package com.tyn.boot.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class PropertyRunner implements ApplicationRunner {
	
	//@Value : properties 파일 에서 설정한 정의 값읋 바로 가져다 사용이 가능하다.
	@Value("${hyunkee.name}")
	private String name;
	
	@Value("${hyunkee.fullname}")
	private String fullname;
	
	@Value("${hyunkee.age}")
	private int age;
	/**
	 * in springframework>
	 * XML에 설정을 해야 했던 부분들이 이렇게 어노테이션 한방으로 설정이 가능하다.
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=============|PropertyRunner:2|=============");
		System.out.println("이름 : "+name);
		System.out.println("성함 : "+fullname);
		System.out.println("나이 : "+age);
	}

	
	
}
