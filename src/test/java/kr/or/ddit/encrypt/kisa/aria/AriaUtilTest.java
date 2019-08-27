package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AriaUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(AriaUtilTest.class);
	/**
	* Method : encryptDecryptTest
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* Method 설명 :aria 블록 암호화 / 복호화 테스트
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	*/
	@Test
	public void encryptDecryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String userId = "browm";

		/***When***/
		String enctyptedText = ARIAUtil.ariaEncrypt(userId);
		String decryptedText = ARIAUtil.ariaDecrypt(enctyptedText);
		
		logger.debug("enctyptedText : {} ", enctyptedText);
		logger.debug("decryptedText : {} ", decryptedText);
		/***Then***/
		assertEquals(userId, decryptedText);
		
	}

}
