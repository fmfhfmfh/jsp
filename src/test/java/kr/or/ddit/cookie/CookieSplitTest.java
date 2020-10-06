package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplitTest {

	@Test
	public void getCookieValueTest() {
		
		/***Given : 주어진 상황 기술***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When : 행위***/
		String result = cookieSplit.getCookieValue("USERID");
		String result2 = cookieSplit.getCookieValue("REMEMBERME");
		String result3 = cookieSplit.getCookieValue("TEST");
				
		/***Then : 결과***/
		assertEquals(result, "brown");
		assertEquals(result2, "Y");
		assertEquals(result3, "t");
	}
}
