package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {
		/*** Given ***/
		MemberDaoI memberDao = new MemberDao();
		String userId = "brown";

		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/*** When ***/
		MemberVO memberVo = memberDao.getMember(userId);

		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
//		assertEquals(answerMemberVo, memberVo);
	}

	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		MemberDaoI memberDao = new MemberDao();

		/*** When ***/
		List<MemberVO> list = memberDao.selectAllMember();

		/*** Then ***/
		assertEquals(list.size(), 15);
	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSession();
		PageVO pv = new PageVO(1, 7);
		// int page = 1;

		/***When***/
		List<MemberVO> list = memberDao.selectMemberPageList(sqlSession, pv);
		
		/***Then***/
		assertEquals(list.size(), 7);
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSession();
		/***When***/
		int cnt = memberDao.selectMemberTotalCnt(sqlSession);
		/***Then***/
		assertEquals(cnt, 15);
	}
	
}
