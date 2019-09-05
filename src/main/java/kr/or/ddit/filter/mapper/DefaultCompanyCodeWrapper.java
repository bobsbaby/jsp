package kr.or.ddit.filter.mapper;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultCompanyCodeWrapper extends HttpServletRequestWrapper{
	
	private Map<String, String[]> requestMap;
	
	public DefaultCompanyCodeWrapper(HttpServletRequest request) {
		super(request);
		requestMap = new HashMap<String, String[]>(request.getParameterMap());
		String unt_cd = request.getParameter("unt_cd");
		
		//unt_cd 파라미터가 null이거나 ""이면 기본값 DDIT로 파라미터 값이 설정되게끔 수정
		if(unt_cd == null || unt_cd.equals("")) {
			unt_cd = "DDIT";
		}
//		unt_cd = unt_cd == null ? "DDIT" : unt_cd;
		requestMap.put("unt_cd", new String[] {unt_cd});
	}
	
	//파라미터 관련된 메소드를 재정의 (map객체에 임의로 파라미터 값을 넣어줌)
	//String getParameter(String parameter)
	//String[] getParameterValues(String parameter)
	//Map<String, String[]> getParameterNames();
	
	@Override
	public String getParameter(String name) {
		String[] values = requestMap.get(name);
		if(values == null ) return null;
		else 		
		return values.length > 0 ? values[0] : null;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		//배열 값 자체를 리턴
		return requestMap.get(name);
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		// enumeration type으로 리턴
	   return Collections.enumeration(requestMap.keySet());
	}
	
	@Override
	public Map<String, String[]> getParameterMap() {
		return requestMap;
	}
	
}
