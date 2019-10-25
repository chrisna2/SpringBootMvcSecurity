package com.tyn.boot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entitiy.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	
	Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void account() throws Exception{
		Account account = new Account();
		account.setUsername("chrisna2");
		account.setPassword("pass");
		account.setEmail("chrisna2@bans.com");
		Account newAcct = accountRepository.save(account);
		log.info(newAcct.getId()+" / "+newAcct.getUsername());
		assertThat(newAcct).isNotNull();
		
		Optional<Account> existAcct = accountRepository.findByUsername(newAcct.getUsername());
		assertThat(existAcct).isNotEmpty();
		
		Optional<Account> notExistAcct = accountRepository.findByUsername("test");
		assertThat(notExistAcct).isEmpty();
		
	}
	
	@Test
	public void inspect() {
		
		//실제 객체의 클래스 이름
		Class<?> clz = accountRepository.getClass();
		
		log.info(clz.getName());
		
		//클래스가 구현하고 있는 인터페이서 목록
		Class<?>[] interfaces = clz.getInterfaces();
		Stream.of(interfaces).forEach(inter -> log.info(inter.getName()));
		
		//클래스의 부모 클래스
		Class<?> superClasses = clz.getSuperclass();
		log.info(superClasses.getName());
		

	}
}
