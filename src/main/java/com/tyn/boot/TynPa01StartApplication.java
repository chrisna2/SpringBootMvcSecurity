package com.tyn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TynPa01StartApplication {

	/* 
	 * IOC(Inversion of Control)
	 * -> 제어의 역전
	 * -> Spring 프레임워크는 IOC 컨테이너를 제공한다.
	 * 	  : 스프링은 왜 개발자가 객체를 만들지 않고 스스로 만드는가?
	 *    1) 자바 클래스 만들고 어노테이션을 추가하면 필요한 기능이 추가된 객체를 생성한다.
	 *    2) 객체 생성을 못하고 내부 적인 설정은 막지만 그 덕에 개발의 생산성이 늘어 난다.
	 *    3) 각각의 디자인 패턴에 대하여 세부적인 설정이 필요한 지점들을 할 필요 없이 각각의 디자인 패턴의 요소들을 추가 할 수 있다. (예, MVC)
	 *    => @BeanFactory @ApplicationContext 등등..
	 * 
	 * DI(Dependency Injection)
	 * -> <bean id="" class="">
	 *    </bean>
	 * -> @Component, @Service, @Repository, @Controller   
	 *    @Autowired, @Value
	 *    
	 *  boot는 위에 위에 XML 설정을 할 필요가 없게 만들었다!
	 * 
	 * -> @ComponentScan(basepackage=""")
	 *   : @Component라고 선언된 값들을 모두 스캔한다.
	 *     legacy> <context:component-scan basepackages="" />
	 *      
	 * -> 3.0 java configuration project
	 * : xml 설정을 java 클래스가 대신한다!
	 * 		=> @Configuration
	 *   
	 */
	public static void main(String[] args) {
		SpringApplication.run(TynPa01StartApplication.class, args);
	}

}
