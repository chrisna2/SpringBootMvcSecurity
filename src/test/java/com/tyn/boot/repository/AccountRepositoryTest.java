package com.tyn.boot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest //application.class 모든 것을 읽는다.
//@DataJpaTest //슬라이스 테스트
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	/*
	@Autowired
	DataSource dataSource;
	
	@Test
	public void conn() throws SQLException {
		try(Connection conn = dataSource.getConnection()){
			System.out.println("==============|DataBaseRunner|=============");
			System.out.println("URL : "+conn.getMetaData().getURL());
			System.out.println("UserName : "+conn.getMetaData().getUserName());
			
			//mariadb로 데이터 소스ㄹ를 변경 하였을 경우 주석처리 하실 것!
			//Statement statement = conn.createStatement();
			//String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY(ID))";
			//statement.executeUpdate(sql);
			//jdbcTemplate.execute("INSERT INTO USER VALUES(1,'HYUNKEENA')");
		}
	}
	*/
	
	@Test
	public void account() throws Exception {
		
		Account account = new Account();
		
		account.setUsername("Spring");
		account.setPassword("2222");
		
		//등록! create : DB날리고 다시 입력하니 괜춘 | update : 있는 데이터를 또 입력하니 안괜춘... 듀플리케잇트
		Account newAcc = accountRepository.save(account);
		System.out.println(newAcc.getId()+" "+newAcc.getUsername());
		assertThat(newAcc).isNotNull();
		
		//조회!
		//Account existAcc = accountRepository.findByUsername(newAcc.getUsername());
		//assertThat(existAcc).isNotNull();

		//없는 것을 조회!
		//Account notExistAcc = accountRepository.findByUsername("test");
		//assertThat(notExistAcc).isNull();

		Optional<Account> optional = accountRepository.findByUsername(account.getUsername());
		
		if(optional.isPresent()) {
			Account existAcount = optional.get();
			System.out.println(existAcount);
		}
		/*
		Optional<Account> optional2 = accountRepository.findByUsername("Spring");
		Account notExistAccont = optional2.orElseThrow(() -> new Exception("존재하지 않습니다."));
		assertThat(notExistAccont).isNotNull();
		*/
	}
}
