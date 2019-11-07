package com.tyn.boot.repository;

import java.util.ArrayList;
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
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tyn.boot.entitiy.PDSBoard;
import com.tyn.boot.entitiy.PDSFile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PDSBoardRepositoryTest {
	
	Logger logger = LoggerFactory.getLogger(PDSBoardRepositoryTest.class);
	
	@Autowired
	PDSBoardRepository pdsbRepo;
	
	//@Test
	@Transactional
	public void testInsertPDS() {
		
		//대빵 데이터
		PDSBoard pds = new PDSBoard();
		pds.setPname("Document");
		
		//pds에 저장될 파일들
		PDSFile file1 = new PDSFile();
		file1.setPdsfiles("file1.doc");
		PDSFile file2 = new PDSFile();
		file2.setPdsfiles("file2.doc");
		
		List<PDSFile> fileList = new ArrayList<PDSFile>();
		fileList.add(file1);
		fileList.add(file2);

		pds.setFiles(fileList);
		
		logger.info("try to save pds");
		
		pdsbRepo.save(pds);
		
	}
	
	//@Test
	public void testUpdateFileName1() {
		
		Long fno = 1L;
		String newName = "updateedFile1.doc";
		int count = pdsbRepo.updatePDSFile(fno, newName);
		logger.info("@update count : "+count);
		
	}
	
	/*
		[정리] @Test 메서드 = @Service
		----------------------------------------------------
		 테스트 코드를 생각 할 때 이부부은 MVC 구조의 서비스 단이라고 생각해야 된다.
		 서비스는 기본적으로 트랜잭션 처리가 되는 만큼 테스트코드도 여러개의 서비스 또는
		 트랜잭션을 모아서 처리해야 된다.
	 */
	
	//@Test
	@Transactional
	public void testUpdateFileName2() {
		String newName = "updatedFile2.doc";
		
		//반드시 번호가 존제하는지 확인! PID 2인 객체 확인
		//Optional : 데이터가 존제 하든 존재하지 않든 상관없다. 있으면 다음로직 처리함
		Optional<PDSBoard>  result = pdsbRepo.findById(2L);
		
		result.ifPresent(pds -> {
						logger.info("데이터가 존재! -> update!");
						
						PDSFile target = new PDSFile();
						target.setFno(2L);
						target.setPdsfiles(newName);
						int idx = pds.getFiles().indexOf(target);

						if(idx > -1) {
							//리스트 파일 목록 
							List<PDSFile> list = pds.getFiles();
							list.remove(idx);
							list.add(target);
							pds.setFiles(list);
						}
						pdsbRepo.save(pds);
					});
	}
	
	
	//@Test
	@Transactional
	//@Commit //이걸 추가하지 않으면 실제 업데이트가 되지 않음
	public void deletePDSFile() {
		Long fno = 2L;
		int count = pdsbRepo.deletePDSFile(fno);
		logger.info("DELETE PDSFile : "+count);
	}
	
	
	//@Test
	@Commit
	public void insertDummies() {
		
		List<PDSBoard> list = new ArrayList<>();
		
		IntStream.range(1, 101).forEach( i -> {
			
			PDSBoard pds = new PDSBoard();
			pds.setPname("자료 "+i);
			
			PDSFile file1 = new PDSFile();
			file1.setPdsfiles("file1.doc");
			
			PDSFile file2 = new PDSFile();
			file2.setPdsfiles("file2.doc");
			
			List<PDSFile> fileList = new ArrayList<>();
			fileList.add(file1);
			fileList.add(file2);
			
			pds.setFiles(fileList);
			
			logger.info("try to save Pds");
			
			list.add(pds);
	
		});
		
		pdsbRepo.saveAll(list);
		
	}
	
	
	//@Test
	@Transactional//엔티티 관계에서 서로 조인을 건 상황에서는 반드시
	public void viewSummary() {
		pdsbRepo.getSummery().forEach(
				arr -> logger.info(Arrays.toString(arr)));
	}
	
	
	
}
