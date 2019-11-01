package com.tyn.boot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tyn.boot.entitiy.Account;

public interface AccountCrudRepository extends CrudRepository<Account, Long>{
	
	/* 클래스는 클래스끼리 extends
	 * 인터페이스는 인터페이스 끼릴 extends
	 * 클래스에서 인터페이스는 implements
	 */
	
	//List<T> findBy + 속성 이름 (속성타입)
	public List<Account> findByUsername(String username);
	
	//Collection<T> findBy + 속성 이름 (속성타입)
	public Collection<Account> findByEmail(String email);
	
	
	
}
