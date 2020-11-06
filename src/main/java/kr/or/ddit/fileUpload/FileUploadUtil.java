package kr.or.ddit.fileUpload;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	// form-data; name="img"; filename="5.png"
	// ==> 5.png
	
	// FileUploadUtilTest
	public static String getFileName(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		
		for (String attr : attrs) {
			String[] val = attr.split("=");
			if(val[0].equals("filename")) {
				return val[1].replaceAll("\"", "");
			}
		}
		return "";
	}
	
	// filename : sally.png ==> png
	public static String getExtension(String filename) {
		
		if(filename == null || filename.indexOf(".") == -1) {
			return "";
		}else {
			return filename.split("[.]")[1];
		}
	}
}
