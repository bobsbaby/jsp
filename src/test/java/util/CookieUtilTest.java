package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {

	@Test
	public void getCookieTest() {
		
		String cookieString = "userId=brown; rememberMe=Y; test=testValue";
		
		String cookieValue = CookieUtil.getCooKie(cookieString, "uesrId");
		String rememberMeCookieValue = CookieUtil.getCooKie(cookieString, "rememberMe");
		String testCookieValue = CookieUtil.getCooKie(cookieString, "test");
		String notExistCookie = CookieUtil.getCooKie(cookieString, "notExists");
		
		assertEquals("brown", cookieValue);
		assertEquals("y", rememberMeCookieValue);
		assertEquals("testValue", testCookieValue);
		assertNull(notExistCookie);
	}

}
