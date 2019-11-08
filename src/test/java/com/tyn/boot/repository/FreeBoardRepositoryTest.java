package com.tyn.boot.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tyn.boot.entitiy.FreeBoard;
import com.tyn.boot.entitiy.FreeBoardReply;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class FreeBoardRepositoryTest {
	
	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	@Autowired
	FreeBoradRepository boardRepo;
	
	Logger logger = LoggerFactory.getLogger(FreeBoardRepositoryTest.class);
	
	//@Test//게시글 등록
	public void insertDummy() {
		IntStream.range(1, 100).forEach(i -> {
			
			FreeBoard board = new FreeBoard();
			board.setTitle("Free Board ... "+i);
			board.setContent("Free Content ... "+i);
			board.setWriter("user"+i%10);
			
			boardRepo.save(board);
		});
	}
	
	/**
	 * 양방향식 댓글 추가시 로직
	 */
	//@Test
	@Transactional //댓글 쪽에 변경이 발생하기 때문에 트랜잭션 처리
	public void insertReply2Way() {
		
		Optional<FreeBoard> result = boardRepo.findById(199L);
		
		result.ifPresent(board -> {
			
			List<FreeBoardReply> replies = board.getReplies();
			
			FreeBoardReply reply = new FreeBoardReply();
			
			reply.setReply("Reply .......... ");
			reply.setReplyer("Replyer00");
			reply.setBoard(board);

			//failed to lazily initialize a collection of role
			replies.add(reply);
			
			board.setReplies(replies);
			
			boardRepo.save(board);
			
		});
	}
	
	//@Test
	public void insertReply1Way() {
		
		FreeBoard board = new FreeBoard();
		board.setBno(199L);
		
		FreeBoardReply reply = new FreeBoardReply();
		reply.setReply("댓글..........");
		reply.setReplyer("Replyer00");
		reply.setBoard(board);
		
		replyRepo.save(reply);
		
	}
	
	// @Test
	public void testList1() {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.findByBnoGreaterThan(0L, page).forEach(board -> {
			logger.info(board.getBno()+" : "+board.getTitle());
		});
		
	}
	
	//@Test
	@Transactional
	public void testList2() {
		 Pageable page = PageRequest.of(9, 10, Sort.Direction.DESC, "bno");
		 
		 boardRepo.findByBnoGreaterThan(0L, page).forEach( board -> {
			 
			 logger.info(board.getBno()+": "+board.getTitle()+": "+board.getReplies().size());
			 
		 });
	}
	
	@Test
	public void testList3() {
		
		Pageable page = PageRequest.of(9, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.getPage(page).forEach(arr ->{
			logger.info(Arrays.toString(arr));
		});
		
	}
	
}
