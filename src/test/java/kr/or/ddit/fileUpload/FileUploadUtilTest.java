package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);
	

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"5.png\"";
		
		/***When***/
		String fileName = FileUploadUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("5.png", fileName);
	}

	@Test
	public void UUIDTest() {
		/***Given***/
		
		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}", uuid);
		
		/***Then***/
	}
	
	@Test
	public void fileNametest() {
		/***Given***/
		String filename = "5";
		
		/***When***/
		String ext = FileUploadUtil.getExtension(filename);
		
		/***Then***/
		assertEquals("", ext);
	}
	
	
}
