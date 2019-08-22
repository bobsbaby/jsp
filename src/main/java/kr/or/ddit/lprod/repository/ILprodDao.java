package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;

public interface ILprodDao {
	
	/**
	* Method : getLprodList
	* 작성자 : PC-05
	* 변경이력 :
	* @return
	* Method 설명 : 전제 제품 그룹 리스트 조회 
	*/
	List<LprodVo> getLprodList(SqlSession sqlSession);
	
	/**
	* Method : getLprodPagingList
	* 작성자 : PC-05
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품 그룹 페이징 리스트 조회 
	*/
	List<LprodVo> getLprodPagingList(SqlSession sqlSession, Page page);
	
	/**
	* Method : getlprodTotalCnt
	* 작성자 : PC-05
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전제 제품그룹 수 조회
	*/
	int getlprodTotalCnt(SqlSession sqlSession);
	
}
