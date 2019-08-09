package util;

public class CookieUtil {

	/**
	* Method : getCooKie
	* 작성자 : PC-05
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 :쿠키 문자열로부터 특정 쿠키의 값을 반환한다. 
	*/
	public static String getCooKie(String cookieString, String cookieId) {
		//cookieString : "userId=brown; rememberMe=Y; test=testValue";
		//cookieId : brown
		String[] start = cookieString.split(";");
		
		//cookies[0] = "userId=brown;"
		//cookies[1] = "rememberMe=Y;"
		//cookies[2] = "test=testValue";
		for(String cookie : start ) {
			String[] cookieNmVal = cookie.split("=");
			if(cookieId.equals(cookieNmVal[0]))
				return cookieNmVal[1];
			//for 1 cookieNmVal[0] = userId cookieNmVal[1] = brown
		}
		return null;
	}
}


