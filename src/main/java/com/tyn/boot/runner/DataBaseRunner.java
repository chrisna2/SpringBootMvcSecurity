package com.tyn.boot.runner;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/***
 * 데이터 베이스 접속 정보 확인 
 * @author User
 */
@Component
public class DataBaseRunner implements ApplicationRunner {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection conn = dataSource.getConnection()){
			System.out.println("==============|DataBaseRunner|=============");
			System.out.println("URL : "+conn.getMetaData().getURL());
			System.out.println("UserName : "+conn.getMetaData().getUserName());
			
			//mariadb로 데이터 소스ㄹ를 변경 하였을 경우 주석처리 하실 것!
			/*
			Statement statement = conn.createStatement();
			String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY(ID))";
			statement.executeUpdate(sql);
			jdbcTemplate.execute("INSERT INTO USER VALUES(1,'HYUNKEENA')");
			*/
		}
		
	}
	
	
	
}
