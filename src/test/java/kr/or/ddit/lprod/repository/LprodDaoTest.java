package kr.or.ddit.lprod.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.lprod.model.LprodVo;

public class LprodDaoTest {

	/**
	* Method : getLprodListTest
	* 작성자 : PC-05
	* 변경이력 :
	* Method 설명 :getLprodList Test 예~~~~~★★★ 
	*/
	@Test
	public void getLprodListTest() {
		/***Given***/
		ILprodDao lprodDao = new LprodDao();

		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodList();
		/***Then***/
		assertEquals(10, lprodList.size());
	}

}
