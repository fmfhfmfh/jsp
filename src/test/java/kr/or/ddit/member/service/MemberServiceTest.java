package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {

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
}
