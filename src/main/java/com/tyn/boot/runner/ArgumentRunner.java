package com.tyn.boot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ArgumentRunner implements ApplicationRunner{
	
	@Autowired
	private String hello;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=============|ArgumentRunner:1|=============");
		//vn argument
		System.out.println("foo =>"+args.containsOption("foo"));
		//program argument
		System.out.println("bar =>"+args.containsOption("bar"));
		//로그 레벨을 맟추기 위해서 사용 가능하다.
		
		//해당 환경이 운영 환경이냐 테스트 환경이냐에 따라서 설정 파일이 달라 질수 있다.
		System.out.println("현재 환경 : "+hello);
	}

}
