package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig {

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVO mv = new MemberVO("ddit", "dditpass", "대덕", "404", "", "", "", "", "");
		
		/***When***/
		int cnt = memberService.insertMember(mv);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
//	@Test
	public void insertMember_FAIL_Test() {
		/***Given***/
		MemberVO mv = new MemberVO("ddit", "dditpass", "대덕", "404", "", "", "", "", "");
		
		/***When***/
		int cnt = memberService.insertMember(mv);
		
		/***Then***/
		assertEquals(1, cnt);
	}

}
