package com.tyn.boot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

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
		Account newAcct = accountRepository.save(account);
		log.info(newAcct.getId()+" / "+newAcct.getUsername());
		assertThat(newAcct).isNotNull();
		
		Optional<Account> existAcct = accountRepository.findByUsername(newAcct.getUsername());
		assertThat(existAcct).isNotEmpty();
		
		Optional<Account> notExistAcct = accountRepository.findByUsername("test");
		assertThat(notExistAcct).isEmpty();
		
	}
}
