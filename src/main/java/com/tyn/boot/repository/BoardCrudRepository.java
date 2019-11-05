package com.tyn.boot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tyn.boot.entitiy.Board;

public interface BoardCrudRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{

	//List<T> findBy + 속성 이름 (속성타입)
	public List<Board> findBoardByTitle(String title);
	
	//Collection<T> findBy + 속성 이름 (속성타입)
	public Collection<Board> findByWriter(String writer);
	
	//like 구문 처리 + order by desc 처리 
	public Collection<Board> findByWriterContainingOrderByBnoDesc(String writer);
	
	/*
		AOP 포인트 컷으로 매서드에 키워드에 따라 출력되는 쿼리의 내용도 변경된다.
	 */
	
	//title like %title% and content like %content%
	public Collection<Board> findByTitleContainingAndContentContaining(String title, String content);
	
	//부등호 처리 : title %?% and bno > ?
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);
	
	// 페이징 처리 : bno > ? Order By bno DESC limit ?, ?
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	
	// 페이징 처리 : bno > ? limit ?, ?
	//public List<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	// 페이징 처리 : Page<T> : 메소드 이름에 민감하다....
	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	/*
	 	한개의 테이블이고 복잡한 로직이 아니면 위와 같이 할 수 있는데 만약 엄청나게 복잡한 로직을 구성해야되는 경우 위에 처럼 
	 	수 만가지를 나열하며 메서드를 만들때 엄청난 문제가 발생할 수 있다.
	 	
	 	이런 경우 두가지의 방법이 제시가 되는데 첫번째는 @Query 사용이다. 해당 쿼리는 dbms에 맞게 변환되는 변동형 쿼리다.
	 	실제로 사용되는 쿼리와 구분이 필요하다.
	 */
	//@Query 사용 : 여기에는 테이블 명이 아닌 엔티티 명이 사용된다. %?1% 헤당 파라미터 값이 들어간다. 순서대로
	@Query("SELECT b "
			+ "FROM Board b "
			+ "WHERE b.title LIKE %?1% "
			+ "AND b.bno > 0 "
			+ "ORDER BY b.bno DESC")
	public List<Board> findByTitle(String title);
	
	//@Query 사용 2 : 파라미터 설정을 지정해서 할 수도 있다 (@param)
	@Query("SELECT b "
			+ "FROM Board b "
			+ "WHERE b.content LIKE %:content% "
			+ "AND b.bno > 0 "
			+ "ORDER BY b.bno DESC")
	public List<Board> findByContent(@Param("content") String content);

	//@Query 사용 3 : 필요한 컬럼만 뽑아서 조회가능 리턴 결과는 Object[] 고정
	@Query("SELECT b.bno, b.title, b.writer, b.regdate "
			+ "FROM Board b "
			+ "WHERE b.title LIKE %?1% "
			+ "AND b.bno > 0 "
			+ "ORDER BY b.bno DESC")
	public List<Object[]> findByTitle2(String title);
	
	//@Query 사용 4 : nativeQuery 사용 -> DBMS에서 사용되는 쿼리의 형태를 그대로 적용, 테이블명도 그대로 써야됨
	@Query(value="SELECT b.bno, b.title, b.writer, b.regdate "
			+ "FROM tbl_boards b "
			+ "WHERE b.title LIKE CONCAT('%',?1, '%') "
			+ "AND b.bno > 0 "
			+ "ORDER BY b.bno DESC", nativeQuery=true)
	public List<Object[]> findByTitle3(String title);
	
	//@Query 사용 5 : 페이징을 활용하기위해 pageable 사용
	@Query("SELECT b "
			+ "FROM Board b "
			+ "WHERE b.bno > 0 "
			+ "ORDER BY b.bno DESC")
	public List<Board> findByPage(Pageable pageable);
	
	/*
		위에 @Query에 경우 고정 쿼리만 입력이 가능하다. mybatis와 같이 동적 쿼리를 활용하고 싶으면
		따로 의존성을 추가해야한다. Querydsl 추가
	 */
	
	
}
