package com.tyn.boot.runner;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseRunner implements ApplicationRunner {
	
	@Autowired
	DataSource dataSource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection conn = dataSource.getConnection()){
			System.out.println("==============|DataBaseRunner|=============");
			System.out.println("URL : "+conn.getMetaData().getURL());
			System.out.println("UserName : "+conn.getMetaData().getUserName());
		}
		
	}
	
	
	
}
