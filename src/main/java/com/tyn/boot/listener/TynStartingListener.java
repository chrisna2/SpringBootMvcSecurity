package com.tyn.boot.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

//starting listener 생성 : 스프링 컨테이너가 생성되기 전에 실행하는 클래스 따라서 application.run 하기 전에 해당 리스너를
//Application 클래스에 등록 해줘야 한다.따로 컴포넌트는 등록할 필요 없음.
public class TynStartingListener implements ApplicationListener<ApplicationStartingEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("Applicaton Starting Listener : "+event.getTimestamp());
	}
}
