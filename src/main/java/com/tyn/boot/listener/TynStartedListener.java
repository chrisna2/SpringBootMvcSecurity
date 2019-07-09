package com.tyn.boot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component// 이미 컨테이너가 생성 된 시점에서 실행 되기 때문에 컴퍼넌트로 등록을 해야 실행이 된다.
public class TynStartedListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("Application started Event : "+ event.getTimestamp());
	}

}
