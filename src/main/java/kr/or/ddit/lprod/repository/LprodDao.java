package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.MybatisUtil;

public class LprodDao implements ILprodDao {

	/**
	* Method : getLprodList
	* 작성자 : PC-05
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품 그룹 전체 리스트 조회 
	*/
	@Override
	public List<LprodVo> getLprodList(SqlSession sqlSession) {
		return sqlSession.selectList("lprod.getLprodList");
	}

	/**
	* Method : getLprodPagingList
	* 작성자 : PC-05
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품 그룹 페이징 리스트 조회 
	*/
	@Override
	public List<LprodVo> getLprodPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	/**
	* Method : getlprodTotalCnt
	* 작성자 : PC-05
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 제품그룹 수 조회 
	*/
	@Override
	public int getlprodTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("lprod.getlprodTotalCnt");
	}

}
