package com.tyn.boot.repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entitiy.Board;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoradRepositoryTest {

	@Autowired
	BoardCrudRepository repository;
	
	@Test
	public void test01Insert200() {
		for(int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("제목 ... "+i); 
			board.setContent("내용..."+i+"...채우기");
			board.setWriter("사용자0"+(i%10));
			repository.save(board);
		}
	}

//	@Test
//	public void test02ByUsername() {
//		repository.findBoardByTitle("제목 ... 20")
//				.forEach(board -> System.out.println(board));
//	}
//	
//	@Test
//	public void test03ByEmail() {
//		Collection<Board> results = repository.findByWriter("사용자00");
//		results.forEach(account -> System.out.println(account));
//	}

//	@Test
//	public void test04ByWriterContaining() {
//		Collection<Board> results = repository.findByWriterContainingOrderByBnoDesc("05");
//		results.forEach(board -> System.out.println(board));
//	}
//	
//	@Test
//	public void test05ByContainOrTitleContent() {
//		Collection<Board> results = repository.findByTitleContainingAndContentContaining("10", "07");
//		results.forEach(board -> System.out.println(board));
//	}
//	
//	@Test
//	public void test06findByTitleContainingAndBnoGreaterThan() {
//		Collection<Board> results = repository.findByTitleContainingAndBnoGreaterThan("20", 200L);
//		results.forEach(board -> System.out.println(board));
//	}
	
//	@Test
//	public void test07PagingTest() {
//		//스프링 부트 2.0.0 이상
//		Pageable paging = PageRequest.of(3,  10); // 3페이지의 10개의 값만 출력
//		Collection<Board> results = repository.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
//		results.forEach(board -> System.out.println(board));
//		
//		//order by 생략시 다음과 같이 사용가능
//		Pageable paging2 = PageRequest.of(4,  10, Sort.DEFAULT_DIRECTION.DESC, "bno"); // 4페이지, 10개의 값만 출력 - bno 역순으로
//		Page<Board> results2 = repository.findByBnoGreaterThan(0L, paging2);
//		List<Board> data = results2.getContent();
//		data.forEach(board -> System.out.println(board));
//		
//	}
//	
//	@Test
//	public void test08PagingSort() {
//		
//		//spirng boot 2.0.0 
//		Pageable paging = PageRequest.of(0,  10, Sort.DEFAULT_DIRECTION.ASC, "bno");
//		
//		Page<Board> result = repository.findByBnoGreaterThan(0L, paging);
//		
//		System.out.println("Page Size:"+result.getSize());
//		System.out.println("Total Pages:"+result.getTotalPages());
//		System.out.println("Total count:"+result.getTotalElements());
//		System.out.println("Next:"+result.nextPageable());
//		
//		List<Board> list = result.getContent();
//		
//		list.forEach(b -> System.out.println(b));
//
//	}
//	
//	@Test
//	public void test09ByTitle2() {
//		repository.findByTitle("17")
//				  .forEach(board -> System.out.println(board));
//	}
//	
//	@Test
//	public void test10ByContent2() {
//		repository.findByContent("18")
//		.forEach(board -> System.out.println(board));
//	}
	
//	@Test
//	public void test11ByTitle3() {
//		repository.findByTitle2("19")
//		.forEach(board -> System.out.println(Arrays.toString(board)));
//	}

//	@Test
//	public void test11ByTitle4() {
//		repository.findByTitle3("20")
//		.forEach(board -> System.out.println(Arrays.toString(board)));
//	}

	@Test
	public void test12ByPage() {
		Pageable pageable = PageRequest.of(0, 10);
		repository.findByPage(pageable)
				  .forEach(b -> System.out.println(b));
	}
	
	
	
	
	
	
}
