package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserService implements IUserService {
	
	private IUserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	@Override
	public List<User> getUserList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = userDao.getUserList(sqlSession);
		sqlSession.close();
		return userList;
	}

	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		User user = userDao.getUser(sqlSession, userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserListOnlyHalf() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = userDao.getUserListOnlyHalf(sqlSession);
		sqlSession.close();
		return userList;
	}
	
	/**
	* Method : getUserPagingListTest
	* 작성자 : PC-05
	* 변경이력 :
	* Method 설명 :사용자 페이징 리스트 조회 테스트
	*/
	@Override
	public Map<String, Object> getUserPagingList(Page page) {
		Map<String, Object > map = new HashMap<String, Object>();
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = userDao.getUserPagingList(sqlSession, page);
		int totalCnt = userDao.getUserTotalCnt(sqlSession);
		
		map.put("userList", userList);
		map.put("pagenationSize", (int)Math.ceil((double)totalCnt/page.getPagesize()));
		sqlSession.close();
		
		return map;
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int num = userDao.insertUser(sqlSession, user);
		sqlSession.commit();
		sqlSession.close();
		
		return num;
	}

	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int delNum = userDao.deleteUser(sqlSession, userId);
		sqlSession.commit();
		sqlSession.close();
		
		return delNum;
	}

	@Override
	public int updateUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insNum = userDao.updateUser(sqlSession, user);
		sqlSession.commit();
		sqlSession.close();
		
		return insNum;
	}
	
	
	

}
