package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

//	테스트 메서드 실행 사이클 : [@BeforeClass] @Before => @Test => @After [@AfterClass]
	
	MemberDaoI memberDao;
	
	@Before
	public void setUp() {
		MemberDaoI memberDao = new MemberDao();
		String userid = "pkh";
		
		memberDao.deleteMember(userid);
	}
	
	@Test
	public void getMemberTest() {
		/*** Given ***/
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
		memberDao = new MemberDao();

		/*** When ***/
		List<MemberVO> list = memberDao.selectAllMember();

		/*** Then ***/
		assertEquals(list.size(), 15);
	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		memberDao = new MemberDao();
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
		memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSession();
		/***When***/
		int cnt = memberDao.selectMemberTotalCnt(sqlSession);
		/***Then***/
		assertEquals(cnt, 15);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
		MemberVO mv = new MemberVO("pkh", "pass1234", "park", "user", "대전 중구 중앙로 76", "영민 빌딩 404호", "34940", "d:\\profile\\pkh.png", "pkh.png");
		/***When***/
		int cnt = memberDao.insertMember(mv);
		
		/***Then***/
		assertEquals(cnt, 1);
	}
}
