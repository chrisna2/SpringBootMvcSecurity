package com.tyn.boot.repository;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entitiy.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountCrudRepositoryTest {
	

	@Autowired
	AccountCrudRepository repository;
	
	@Test
	public void test01Insert200() {
		
		for(int i = 1; i <= 200; i++) {
			Account account = new Account();
			account.setEmail("member"+i+"@gmsss.com");
			account.setUsername("member"+i);
			account.setPassword("$%password"+(i%10));
			repository.save(account);
		}
	}

	@Test
	public void test02ByUsername() {
		repository.findByUsername("member20")
				.forEach(account -> System.out.println(account));
	}
	
	@Test
	public void test03ByEmail() {
		Collection<Account> results = repository.findByEmail("member30@gmsss.com");
		results.forEach(account -> System.out.println(account));
	}
	
}
