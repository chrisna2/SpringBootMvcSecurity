package com.tyn.boot.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.tyn.boot.entitiy.Member;
import com.tyn.boot.entitiy.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit //테스크 결과를 DB에 반영
public class ProfileRepositoryTest {
	
	Logger logger = LoggerFactory.getLogger(ProfileRepositoryTest.class);
	
	@Autowired
	MemberRepository memRepo;
	
	@Autowired
	ProfileRepository prfRepo;
	
//	@Test
//	public void test01InsertMembers() {
//		//<!> for 문 대신에 사용 사능 한 방법 이다. 1 ~ 100 까지의 정수 100명 적용
//		IntStream.range(1, 101)
//				 .forEach(number -> {
//					 Member member = new Member();
//					 member.setUid("user"+number);
//					 member.setPwd("password"+number);
//					 member.setUname("사용자_"+number);
//					 memRepo.save(member);
//				 });
//	}
	
//	@Test
//	public void test02InsertProfile() {
//		
//		//다 대 1 관계의 테이블 관계에서는 1인 테이블의 설정이 제일 우선시 된다.
//		Member member = new Member();
//		//우선 관계키의 값을 설정 한다. 
//		member.setUid("user1");
//		
//		for (int i = 1; i < 5; i++) {
//			
//			Profile profile1 = new Profile();
//			profile1.setFname("face"+i+".jpg");
//			
//			if(i==1) {
//				profile1.setCurrent(true);
//			}
//			profile1.setMember(member);
//			
//			prfRepo.save(profile1);
//		}
//	}
	
	@Test
	public void test03FetchJoin1() {
		List<Object[]> result = memRepo.getMemberWithProfileCount("user2");
		result.forEach(arr -> logger.info(Arrays.toString(arr)));
	}
	
	@Test
	public void test04FetchJoin2() {
		List<Object[]> result = memRepo.getMemberWithProfile("user1");
		result.forEach(arr -> logger.info(Arrays.toString(arr)));
	}
	
	
	
	
	
	
	
	
	
}
