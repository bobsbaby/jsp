package kr.or.ddit.lprod.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoTest {
	
	private ILprodDao lprodDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("before");
		lprodDao = new LprodDao();
		sqlSession = MybatisUtil.getSession();
	}
	//test에 공통적으로 사용한 자원을 해제 
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	/**
	* Method : getLprodListTest
	* 작성자 : PC-05
	* 변경이력 :
	* Method 설명 :getLprodList Test 예~~~~~★★★ 
	*/
	@Test
	public void getLprodListTest() {
		/***Given***/
		

		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodList(sqlSession);
		logger.debug(lprodList.size() + "0");
		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	/**
	* Method : getLprodPagingListTest
	* 작성자 : PC-05
	* 변경이력 :
	* Method 설명 :전체 제품 그룹 건수 조회 
	*/
	@Test 
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(2);

		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodPagingList(sqlSession, page);
		/***Then***/
		assertEquals(2, lprodList.size());
	}
	
	/**
	* Method : getlprodTotalCnt
	* 작성자 : PC-05
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 제품그룹 수 조회 
	*/
	@Test
	public void getlprodTotalCnTest() {
		/***Given***/
		

		/***When***/
		int totalCnt = lprodDao.getlprodTotalCnt(sqlSession);
		
		/***Then***/
		assertEquals(10, totalCnt);
	}

}
