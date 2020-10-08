package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ranger.service.RangerService;
import ranger.service.RangerServiceI;

public class CookieSplitTest {

	@Test
	public void getCookieValueSuccesstest() {
		
		/***Given : 주어진 상황 기술***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When : 행위 ***/
		String cookieValue = cookieSplit.getCookieValue("USERNM");

		/***Then : 결과 ***/
		assertEquals("brown", cookieValue);
		
	}
	
	@Test
	public void getCookieValueFailTest() {
//		/***Given : 주어진 상황 기술***/
//		CookieSplit cookieSplit = new CookieSplit();
//		
//		/***When : 행위 ***/
//		String cookieValue = cookieSplit.getCookieValue("PASSWORD");
//		
//		/***Then : 결과 ***/
//		assertEquals("", cookieValue);

	}

}
