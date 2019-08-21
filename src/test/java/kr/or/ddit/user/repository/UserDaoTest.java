package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IUserDao userDao;
	private SqlSession sqlSession;
	
	//junit test method 실행 순서 
	//@before -> @test -> @after
	//@Test 테스트 메소드가 실행되기 전에 @Before이 적용된 메소드를 먼저 실행하고, @Test 메소드 실행 후 @After이 적용된 메소드를 실행한다. 
	//@Text 메소드는 실행순서가 보장되지 않음
	
	//test에 공통적으로 필요한 자원을 생성 / 초기화 
	@Before
	public void setup() {
		logger.debug("before");
		userDao = new UserDao();
		SqlSession sqlSession = MybatisUtil.getSession();
	}
	//test에 공통적으로 사용한 자원을 해제 
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}
	/**
	* Method : getUserListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListTest() {
		/***Given***/
		
		
		/***When***/
		List<User> userList = userDao.getUserList(sqlSession);

		/***Then***/
		assertEquals(105, userList.size());
	}

	/**
	* Method : getUserTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";

		
		/***When***/
		User userVo = userDao.getUser(sqlSession, userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
	}
	
	/**
	* Method : getUserListOnlyHalf
	* 작성자 : PC-05
	* 변경이력 :
	* Method 설명 : 멤버 50개의 데이터만 조회 테스트~~~~
	*/
	@Test
	public void getUserListOnlyHalf() {
		/***Given***/
		/***When***/
		List<User> userList = userDao.getUserListOnlyHalf(sqlSession);

		/***Then***/
		assertEquals(50, userList.size());
	}
}
