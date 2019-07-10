package com.tyn.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyn.boot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
//JpaRepository<entity클래스, 프라이머리 키 밸류 타입>
	
	Account findByUsername(String username);
	
	
	//업데이트가 없다! SAVE(T) 이게 일반적으로 생각하는 저장기능과 동일하다. 아이디가 없으면 입력, 있으면 수정. 놀랍다!
	
}
