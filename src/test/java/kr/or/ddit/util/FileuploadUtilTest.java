package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileuploadUtilTest {

	/**
	* Method : getFilenametest
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로부터 파일 이름 추출 테스트
	*/
	@Test
	public void getFilenametest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";

		/***When***/
	    String filename = FileuploadUtil.getFilenametest(contentDisposition);
		/***Then***/
	    assertEquals("brown.png", filename);
	}

	/**
	* Method : getFilenametest
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로부터 파일 확장자 추출 테스트
	*/
	@Test
	public void getFileExtensiontest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDisposition2 = "form-data; name=\"file\"; filename=\"brown\"";
		String contentDisposition3 = "form-data; name=\"file\"; filename=\"brown.png.jpg\"";
		

		/***When***/
	    String fileExtension = FileuploadUtil.getFileExtension(contentDisposition);
	    String fileExtension2 = FileuploadUtil.getFileExtension(contentDisposition2);
	    String fileExtension3 = FileuploadUtil.getFileExtension(contentDisposition3);
		/***Then***/
	    assertEquals(".png", fileExtension);
	    assertEquals("", fileExtension2);
	    assertEquals(".jpg", fileExtension3);
	}
	
	/**
	* Method : getPathTest
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* Method 설명 : 파일 업로드 경로 조회하기 테스트
	*/
	@Test
	public void getPathTest() {
		/***Given***/
		

		/***When***/
		String path = FileuploadUtil.getPath();
		
		/***Then***/
		assertEquals("d:\\upload\\2019\\08\\", path);
	}
}
