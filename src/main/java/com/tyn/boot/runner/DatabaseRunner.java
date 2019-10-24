package com.tyn.boot.runner;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner{
	
	Logger log = LoggerFactory.getLogger(DatabaseRunner.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection conn = dataSource.getConnection()){
			log.info("H2 database url => "+conn.getMetaData().getURL());
			log.info("H2 database username => "+conn.getMetaData().getUserName());
			
			/*	[H2]
				 H2 database url => jdbc:h2:mem:testdb 
				 H2 database username => SA 
			 */
			
			/* mariadb로 데이터 소스ㄹ를 변경 하였을 경우 주석처리! 그래야 에러가 나지 않는다.
			//테이블 생성 및 데이터 추가후 h2 콘솔에서 확인
			Statement stmt = conn.createStatement();
			String sql =  "CREATE TABLE USER ("
					    + "ID INTEGER NOT NULL,"
					    + "NAME VARCHAR(255),"
					    + "PRIMARY KEY(ID))";
					    
			stmt.executeUpdate(sql);
			JdbcTemplate.execute("insert into user values (1, 'chrisna2')");
			*/
		}
	}
}
