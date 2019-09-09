package kr.or.ddit.mvc.repository;

import java.util.List;

import kr.or.ddit.mvc.model.UrlMapping;

public interface IUrlMappingDao {
	
	/**
	* Method : getUrlMapping
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* @return
	* Method 설명 : urlmapping을 가져온다 
	*/
	List<UrlMapping> getUrlMapping();
}
