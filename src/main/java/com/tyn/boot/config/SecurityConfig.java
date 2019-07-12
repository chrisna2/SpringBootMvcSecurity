package com.tyn.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			//아래의 링크의 경우 로그인을 허용 해야 들어 갈수 있다.
			.antMatchers("/myPage/**").authenticated()
			//그외의 모든 링크는 접속이 가능 하다.
			.antMatchers("/**").permitAll()
			.and()
			.formLogin()
			.and()
			.httpBasic()
			.and()
			.logout()
			.logoutUrl("/app-logout")
			.deleteCookies("JESSIONID")
			.logoutSuccessUrl("/");
		
		
		
	}
}
