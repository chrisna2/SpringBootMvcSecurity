package com.tyn.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyn.boot.entitiy.Account;

//AccountRepository의 구현채를 따로 작성하지 않아도 
//Spring-Data-Jpa가 자동적으로 해당 문자열 username에 대한 인수를 받아 자동적으로 DB-Table과 매핑한다.
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
}
