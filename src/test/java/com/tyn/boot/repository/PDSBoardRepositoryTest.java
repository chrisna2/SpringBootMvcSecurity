package com.tyn.boot.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entitiy.PDSBoard;
import com.tyn.boot.entitiy.PDSFile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PDSBoardRepositoryTest {
	
	Logger logger = LoggerFactory.getLogger(PDSBoardRepositoryTest.class);
	
	@Autowired
	PDSBoardRepository pdsbRepo;
	
	//@Test
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
	
	@Test
	public void testUpdateFileName1() {
		
		Long fno = 1L;
		String newName = "updateedFile1.doc";
		int count = pdsbRepo.updatePDSFile(fno, newName);
		logger.info("@update count : "+count);
		
	}
	
	
	
}
