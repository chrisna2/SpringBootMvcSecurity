package com.tyn.boot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entitiy.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRepositoryTest {
	
	Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void test1Inspect() {
		
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
	
	@Test
	public void test2Insert() {
		Account account = new Account();
		account.setUsername("fuck_my_life");
		account.setPassword("12345");
		account.setEmail("fml@gmail.com");
		accountRepository.save(account);
	}
	
	@Test
	public void test3Account() throws Exception{
		Account account = new Account();
		account.setUsername("chrisna2");
		account.setPassword("pass");
		account.setEmail("chrisna2@bans.com");
		Account newAcct = accountRepository.save(account);
		log.info(newAcct.getId()+" / "+newAcct.getUsername());
		assertThat(newAcct).isNotNull();
		
		Account existAcct = accountRepository.findByUsername(newAcct.getUsername());
		assertThat(existAcct).isNotNull();
		
		Account notExistAcct = accountRepository.findByUsername("test");
		assertThat(notExistAcct).isNull();
		
	}
	
	@Test
	public void test4Read() {
		accountRepository.findById(1L).ifPresent(
					account -> log.info(account.toString()));
	}
	
	@Test
	public void test5Update() {
		log.info("Read First ................ ");
		Optional<Account> account = accountRepository.findById(1L);
		
		log.info("Update name ............... ");
		account.get().setUsername("the_final_winner");
		account.get().setPassword("illbewinner");
		account.get().setEmail("tfw@gmail.com");
		
		log.info("Call save ..............");
		accountRepository.save(account.get());
		
	}
	
	@Test
	public void test6Delete() {
		log.info("Delete ................ ");
		accountRepository.deleteById(2L);
		accountRepository.deleteById(1L);
	}
	
	
}
