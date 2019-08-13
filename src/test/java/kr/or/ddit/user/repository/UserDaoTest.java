package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.User;

public class UserDaoTest {

	/**
	* Method : getUserListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListTest() {
		/***Given***/
		IUserDao userDao = new UserDao();

		/***When***/
		List<User> userList = userDao.getUserList();

		/***Then***/
		assertEquals(5, userList.size());
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
		IUserDao userDao = new UserDao();

		/***When***/
		User userVo = userDao.getUser(userId);

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
		IUserDao userDao = new UserDao();

		/***When***/
		List<User> userList = userDao.getUserListOnlyHalf();

		/***Then***/
		assertEquals(50, userList.size());
	}

}
