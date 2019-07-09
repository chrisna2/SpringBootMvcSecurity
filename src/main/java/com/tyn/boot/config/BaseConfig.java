package com.tyn.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//운영환경에서 적용되는 설정파일
@Profile("prod")
@Configuration
public class BaseConfig {
	
	/*여담
	 * @Component -> class 
	 * @Bean -> method
	 */
	@Bean
	public String hello() {
		return "hello Pord Config";
	}
}
