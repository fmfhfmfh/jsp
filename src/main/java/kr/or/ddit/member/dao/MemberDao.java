package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVO getMember(String userId) {
		// db에서 데이터를 조회하는 로직이 있어야하나
		// controller기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다
		//                  Mock (가짜)
		
//		MemberVO memberVo = new MemberVO();
//		memberVo.setUserId("brown");
//		memberVo.setPassword("passBrown");
		SqlSession sqlSession = MybatisUtil.getSession();
		
		// select
		// 한개 : selectOne
		// 여러개 : selectList
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userId);
		
		
//		sqlSession.commit();
//		sqlSession.rollback();
		
		sqlSession.close();
		
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<MemberVO> list = sqlSession.selectList("member.selectAllMember");

		sqlSession.close();
		
		return list;
	}

}
