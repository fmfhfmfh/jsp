package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest extends ModelTestConfig {
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> list = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(list.size(), 18);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "ddit";
		/***When***/
		MemberVO mv = memberDao.getMember(userid);
		/***Then***/
		assertEquals(mv.getUsernm(), "대덕");
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVO mv = new MemberVO("dspark", "1234", "박경호", "밥", "", "", "", "", "");
		/***When***/
		int cnt = memberDao.insertMember(mv);
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		String userid = "ddit";
		/***When***/
		int cnt = memberDao.deleteMember(userid);
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		String userid = "park";
		MemberVO mv = memberDao.getMember(userid);
		
		mv.setUsernm("하하");
		/***When***/
		int cnt = memberDao.updateMember(mv);
		/***Then***/
		
		assertEquals(cnt, 1);
	}
	
	@Test
	public void selectMemberTotalCnt() {
		/***Given***/
		
		/***When***/
		int cnt = memberDao.selectMemberTotalCnt();
		/***Then***/
		assertEquals(cnt, 18);
	}
	
	
}
