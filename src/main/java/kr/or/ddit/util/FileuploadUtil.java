package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileuploadUtil {

	/**
	 * Method : getFilenametest
	 * 작성자 : ¡U KSR ¡U
	 * 변경이력 :
	 * Method 설명 : Content-disposition 헤더 문자열로부터 파일 이름 추출
	 */
	public static String getFilenametest(String contentDisposition) {
		//메소드 인자 : "form-data; name=\"file\"; filename =\"brown.png\"";
		String[] attrs = contentDisposition.split("; ");
		//attrs[0] =form-data
		//attrs[1] = name="file"
		//attrs[2] = filename ="brown.png"

		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyvalue = attr.split("=");
				filename = keyvalue[1].substring(keyvalue[1].indexOf("\"")+1, keyvalue[1].lastIndexOf("\""));
				break;
			}
		}
		return filename;
	}

	/**
	 * Method : getFileExtensiontest
	 * 작성자 : ¡U KSR ¡U
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 : Content-disposition 헤더 문자열로부터 파일 확장자 추출 
	 */
	public static String getFileExtension(String contentDisposition) {
		String filename = getFilenametest(contentDisposition);

		if(filename.indexOf(".")>0)
			return filename.substring(filename.lastIndexOf("."));
		else 
			return "";
	}

	/**
	* Method : getPath
	* 작성자 : ¡U KSR ¡U
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드 할 경로를 조회한다. 
	*/
	public static String getPath() {
		String basicPath = "d:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date());		//201908
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		File yyyyDirectory = new File(basicPath + "\\" + yyyy +"\\" +  mm);
		if(!yyyyDirectory.exists())
			yyyyDirectory.mkdirs();
		
		return basicPath + "\\" + yyyy +"\\" +  mm + "\\";
	}
}
