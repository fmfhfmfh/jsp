package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUploadUtilTest {

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"5.png\"";
		
		/***When***/
		String fileName = FileUploadUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("5.png", fileName);
	}

}
