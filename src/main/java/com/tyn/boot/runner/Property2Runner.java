package com.tyn.boot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tyn.boot.properties.TynProperties;

@Order(3)
@Component
public class Property2Runner implements ApplicationRunner {
	
	@Autowired
	TynProperties tynproperties;
	//변수가 많은 경우 : 위와 같이 DTO 형태로 가져올 수 있다.
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=============|Property2Runner:3|=============");
		System.out.println("회사명 : "+tynproperties.getEnpNm());
		System.out.println("회사 번호 : "+tynproperties.getEnpNo());
		System.out.println("회사 타입 : "+tynproperties.getEnpType());
	}

	
	
}
