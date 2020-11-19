package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig {

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVO mv = new MemberVO("temp", "dditpass", "대덕", "404", "", "", "", "", "");
		
		/***When***/
		int cnt = memberService.insertMember(mv);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "park";
		/***When***/
		MemberVO mv = memberService.getMember(userid);
		/***Then***/
		assertEquals(mv.getUsernm(), "밥쟁이2");
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> list = memberService.selectAllMember();
		
		/***Then***/
		assertEquals(list.size(), 18);
	}
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		PageVO pv = new PageVO(1, 5);
		/***When***/
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		List<MemberVO> list = (List<MemberVO>) map.get("memberList");
		
		int pages = (int)map.get("pages");
		
		/***Then***/
		assertEquals(list.size(), 5);
		assertEquals(pages, 4);
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		String userid = "ddit";
		/***When***/
		int cnt = memberService.deleteMember(userid);
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		String userid = "park";
		MemberVO mv = memberService.getMember(userid);
		
		mv.setUsernm("하하");
		/***When***/
		int cnt = memberService.updateMember(mv);
		/***Then***/
		
		assertEquals(cnt, 1);
	}
}
