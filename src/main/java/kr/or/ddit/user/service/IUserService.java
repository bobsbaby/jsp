package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	
	/**
	* Method : getUserList
	* 작성자 : PC-05
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 리스트 조회
	*/
	List<User> getUserList();
	
	/**
	* Method : getUser
	* 작성자 : PC-05
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	User getUser(String userId);
	
	/**
	* Method : getUserListOnlyHalf
	* 작성자 : PC-05
	* 변경이력 :
	* @return
	* Method 설명 : 
	*/
	List<User> getUserListOnlyHalf();
	
	/**
	* Method : getUserPagingListTest
	* 작성자 : PC-05
	* 변경이력 :
	* Method 설명 :사용자 페이징 리스트 조회 테스트
	*/
	Map<String, Object> getUserPagingList(Page page);
	
	/**
	* Method : insertUser
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* @param user
	* @return
	* Method 설명 :
	*/
	int insertUser(User user);
	
	/**
	* Method : deleteUser
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :
	*/
	int deleteUser(String userId);
	
	/**
	* Method : updateUser
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* @param user
	* @return
	* Method 설명 : 회원 정보 수정
	*/
	int updateUser(User user);
}
