package com.tyn.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tyn.boot.entitiy.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long>{
	
	@Modifying//DML작업을 추가하기 위해서는 해당 어노테이션 추가 필수 (jpa 컬랙션 인지 확인!)
	@Query("UPDATE FROM PDSFile f set f.pdsfiles = ?2 WHERE f.fno = ?1 ")//기본적으로 select 구문만 지원
	public int updatePDSFile(Long fno, String newFileName);
	
	
	@Modifying
	@Query("DELETE FROM PDSFile f WHERE f.fno = ?1")
	public int deletePDSFile(Long fno);
	
	
	@Query("select p, count(f) "
			+ "from PDSBoard p "
			+ "left outer join p.files f "
			+ "where p.pid > 0 "
			+ "group by p "
			+ "order by p.pid " 
			+ "desc")
	public List<Object[]> getSummery();

}
