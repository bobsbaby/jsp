package kr.or.ddit.prod.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;

public class ProdDao implements IProdDao{

	@Override
	public List<Map> getDetailInfo(String Lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> list = sqlSession.selectList("prod.getDetailInfo", Lprod_gu);
		return list;	
	}
}
