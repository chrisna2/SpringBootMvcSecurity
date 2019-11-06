package com.tyn.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tyn.boot.entitiy.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	
	
	//이런식으로 레프트 조인이 가능하다고는 한다. 그럼이게 Mybatis와 다른게 무었일까...
	@Query("SELECT m.uid, count(p) "
			+ "FROM Member m "
			+ "LEFT OUTER JOIN Profile p "
			+ "ON m.uid = p.member "
			+ "WHERE m.uid = ?1 "
			+ "GROUP BY m")
	public List<Object[]> getMemberWithProfileCount(String uid);
	
	@Query("SELECT m, p "
			+ "FROM Member m "
			+ "LEFT OUTER JOIN Profile p "
			+ "ON m.uid = p.member "
			+ "WHERE m.uid = ?1 "
			+ "AND p.current = true")
	public List<Object[]> getMemberWithProfile(String uid);
	
	
	
}
