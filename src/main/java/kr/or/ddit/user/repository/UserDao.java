package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDao implements IUserDao{

	/**
	* Method : getUserList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<User> getUserList() {
//		// db에서 조회가 되었다고 가정하고, 가짜 객체를 리턴
//		List<UserVo> userList = new ArrayList<UserVo>();
//		
//		userList.add(new UserVo("brown", "1111", "김브라우니"));
//		userList.add(new UserVo("cony", "2222", "정코니"));
//		userList.add(new UserVo("sally", "3333", "장샐리"));
//		userList.add(new UserVo("moon", "4444", "달문"));
//		userList.add(new UserVo("james", "5555", "제임스"));
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = sqlSession.selectList("user.getUserList");
		sqlSession.close(); // 안닫으면 계속된 요청이 있을 때 커넥션객체를 모두 소모하여 응답이 안돌아온다.
		
		return userList;
	}

	/**
	* Method : getUser
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : userId를 갖는 사용자 정보 조히
	*/
	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		User userVo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		return userVo;
	}

	@Override
	public List<User> getUserListOnlyHalf() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> list = sqlSession.selectList("user.getUserListOnlyHalf");
		return list;
	}
	
}
