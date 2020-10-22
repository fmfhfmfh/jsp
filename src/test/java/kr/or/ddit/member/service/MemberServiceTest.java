package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	@Before
	public void setUp() {
		MemberServiceI memberService = new MemberService();
		String userid = "pkh";
		
		memberService.deleteMember(userid);
	}
	
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
//		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();

		/*** When ***/
		List<MemberVO> list = memberService.selectAllMember();

		/*** Then ***/
		assertEquals(list.size(), 15);
	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		PageVO pv = new PageVO(1, 7);
		
		/***When***/
		// memberList 확인
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		List<MemberVO> list = (List<MemberVO>) map.get("memberList");
		
		// member의 전체 수 확인
		int pages = (int)map.get("pages");
		
		
		/***Then***/
		assertEquals(list.size(), 7);
		assertEquals(pages, 3);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		MemberVO mv = new MemberVO("pkh", "pass1234", "park", "user", "대전 중구 중앙로 76", "영민 빌딩 404호", "34940", "d:\\profile\\pkh.png", "pkh.png");
		/***When***/
		int cnt = memberService.insertMember(mv);
		
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for (Locale locale : locales) {
			logger.debug("{}", locale);
		}
	}
}
